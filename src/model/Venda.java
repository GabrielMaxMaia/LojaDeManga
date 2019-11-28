/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author rogerio.slucon
 */
public class Venda {
 
    private int id, produtos, funcionarios;
    private float valor;
    private String cliente, data;
    private ArrayList<Produto> listaProdutos;

    public Venda(int id, String cliente, int produtos, int funcionarios) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.funcionarios = funcionarios;
    }

    public Venda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getProdutos() {
        return produtos;
    }

    public void setListaProdutos(ArrayList listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos; 
    }
    
    public int getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(int funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}