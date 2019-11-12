package controller;

import dao.DAOVenda;
import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.tableModels.CarrinhoTableModel;
import model.Produto;
import model.VendaTemporaria;
import model.tableModels.RelatorioDinamicoTableModel;

/**
 *
 * @author rogerio.slucon
 */
public class VendaController {
    private static VendaController INSTANCE;
    private CarrinhoTableModel table = new CarrinhoTableModel();
    private ClienteController cliController;
    private ProdutoController prodController;
    private RelatorioDinamicoTableModel dinamico = new RelatorioDinamicoTableModel();

    public static VendaController getVendaController(){
        if(INSTANCE != null){
            return INSTANCE;
        }else{
            return INSTANCE = new VendaController();
        }
    }
    
    private VendaController() {
        cliController = ClienteController.getClienteController();
        prodController = ProdutoController.getProdutoController();
    }

    public boolean addCarrinho(String idProd, String qtd) {
        Produto prod = prodController.pesquisaPorId(Integer.parseInt(idProd));
        int qtdInt = Integer.parseInt(qtd);

        if (prod != null && qtdInt > 0) {

            if (prod.getQtd() >= qtdInt) {
                table.addProd(prod, qtdInt);
                return true;
            }
        }
        return false;
    }

    public void finalizarCompra(String cpf) {
        ArrayList<Produto> produtos = table.getLista();
        ArrayList<Integer> qtd = table.getQtdLista();
        ArrayList<Produto> todosProd = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            for (int j = 0; j < qtd.get(i); j++) {
                todosProd.add(produtos.get(i));
            }
        }
        DAOVenda dao = new DAOVenda();
        Date d = new Date();
        String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        VendaTemporaria venda = new VendaTemporaria(todosProd);
        venda.setCliente(cpf);
        dao.gerarVenda(venda);
        dinamico.atualiza();
    }

    public void cancelarCompra() {
        table.cancelarCompra();
    }

    public CarrinhoTableModel getModel() {
        return table;
    }
    
    public RelatorioDinamicoTableModel getRelatorioDinamicoTableModel(){
        return dinamico;
    }
    
    public float getTotal (){
        float total = 0;
        ArrayList<Float> aux = table.getTotalLista();
        for (Float index : aux) {
            total += index;
        }
        return total;
    }
    
    public boolean validaVenda(String cpf, String id){
        boolean flag = true;
        if(cpf.equals("") || id.equals("")){
            flag = false;
        }
        if(flag && !cliController.filtrarPorCPF(cpf)){
            flag = false;
        }
        if(flag && !prodController.filtrarPorId(id)){
            flag = false;
        }
        return flag;
    }
    
}
