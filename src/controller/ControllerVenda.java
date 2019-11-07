package controller;

import lojademanga.CarrinhoTableModel;
import model.Produto;

/**
 *
 * @author rogerio.slucon
 */
public class ControllerVenda {
    private CarrinhoTableModel table = new CarrinhoTableModel();
    
    public boolean venderProduto(String idProd, String qtd, String desconto){
        
        
        
        
        Produto prod = new Produto();
        int qtdInt = Integer.parseInt(qtd);
        int descontoInt = Integer.parseInt(desconto);
        
        
        if(prod.getQtd() >= qtdInt){
            table.addProd(prod, qtdInt, descontoInt);
            return true;
        }else{
            return false;
        }
    }
}
