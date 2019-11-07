/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import lojademanga.CarrinhoTableModel;
import model.Produto;

/**
 *
 * @author rogerio.slucon
 */
public class ControllerVenda {
    private CarrinhoTableModel table = new CarrinhoTableModel();
    
    public boolean venderProduto(Produto produto, int qtd, int desconto){
        if(produto.getQtd() >= qtd){
            table.addProd(produto, qtd, desconto);
            return true;
        }else{
            return false;
        }
    }
}
