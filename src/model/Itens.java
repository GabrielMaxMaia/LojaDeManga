/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rogerio.slucon
 */
public class Itens {
    private int Produto;
    private int compras;

    public Itens() {
    }
        
    public Itens(int Produto, int compras) {
        this.Produto = Produto;
        this.compras = compras;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public int getProduto() {
        return Produto;
    }

    public void setProduto(int Produto) {
        this.Produto = Produto;
    }
    
}
