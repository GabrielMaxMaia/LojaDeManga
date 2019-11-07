package controller;

import dao.DAOVenda;
import lojademanga.CarrinhoTableModel;
import model.Produto;

/**
 *
 * @author rogerio.slucon
 */
public class ControllerVenda {
    private CarrinhoTableModel table = new CarrinhoTableModel();
    private ProdutoController prodController; 
    public ControllerVenda() {
        prodController = ProdutoController.getProdutoController();
    }
    
    
    
    public boolean venderProduto(String idProd, String qtd, String desconto){
        Produto prod = prodController.pesquisaPorId(Integer.parseInt(idProd));   
        int qtdInt = Integer.parseInt(qtd);
        
        if(prod != null && qtdInt > 0){
            
            int descontoInt = Integer.parseInt(desconto);


            if(prod.getQtd() >= qtdInt){
                table.addProd(prod, qtdInt, descontoInt);
                return true;
            }
        }
        return false;
    }
    
    public CarrinhoTableModel getModel(){
        return table;
    }
}
