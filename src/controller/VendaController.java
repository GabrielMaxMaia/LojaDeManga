package controller;

import dao.DAOItens;
import dao.DAOProduto;
import dao.DAOVenda;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Itens;
import model.tableModels.CarrinhoTableModel;
import model.Produto;
import model.Venda;
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
            if (prod.getQtd() - table.quantosEstaoNoCarrinho(prod) >= qtdInt) {
                table.addProd(prod, qtdInt);
                return true;
            }
        }
        return false;
    }

    public boolean finalizarCompraDois(){
        
        ArrayList<Produto> todosProd = pegaCarrinhoDeCompra();
        
        DAOVenda dao = new DAOVenda();
        Venda venda = new Venda();
        //Problemas Na Converçao 
        venda.setCliente(table.getCliente().getCpf());
        venda.setFuncionarios(1);
        
        try {
            dao.insert(venda);
        } catch (SQLException ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        dao = new DAOVenda();
        
        int idCompra = dao.pegaIdProximaVenda() - 1;
        
        for (Produto produto : todosProd) {
            Itens item = new Itens();
            item.setCompras(idCompra);
            item.setProduto(produto.getId());
            DAOItens daoItens = new DAOItens();
            try {
                daoItens.insert(item);
                DAOProduto daoProd = new DAOProduto();
            } catch (SQLException ex) {
                Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    @Deprecated
    public void finalizarCompra(String cpf) {
        
         ArrayList<Produto> todosProd = pegaCarrinhoDeCompra();
        
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
        dinamico.getComprar();
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
    
    public boolean validaVenda(String cpf){
        boolean flag = true;
        if(cpf.equals("")){
            flag = false;
        }
        if(flag && !cliController.filtrarPorCPF(cpf)){
            flag = false;
        }
        if(table.isEmpty()){
            flag = false;
        }
        return flag;
    }
    
    private ArrayList<Produto> pegaCarrinhoDeCompra(){
        ArrayList<Produto> produtos = table.getLista();
        ArrayList<Integer> qtd = table.getQtdLista();
        ArrayList<Produto> todosProd = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            Produto prod = produtos.get(i);
            DAOProduto dao = new DAOProduto();
            try {
                dao.vender(prod ,qtd.get(i));
            } catch (SQLException ex) {
                Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int j = 0; j < qtd.get(i); j++) {
                todosProd.add(produtos.get(i));
            }
        }
        return todosProd;
    }
    
    public void setCliente(Cliente cliente){
        table.setCliente(cliente);
    }
    
    public void atualizaRelatorio(){
        dinamico.atualiza();
    }
    
}
