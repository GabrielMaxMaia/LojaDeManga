/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Rogerio
 */
public class VendaTemporaria {
    private ArrayList<Produto> produtos;
    private int qtd;
    private float valor;
    private String cliente;
    private String id;
    private String data;

    public VendaTemporaria(ArrayList<Produto> produtos) {
        this.produtos = produtos;
        int qtd = 0;
        float valor = 0;
        
        for (Produto produto : produtos) {
            qtd++;
            valor += produto.getPreco() + produto.getDesconto();
        }
        this.qtd = qtd;
        this.valor = valor;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
        
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
