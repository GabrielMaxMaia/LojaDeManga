/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author raphaela.crwagner
 */
public class Fornecedor {
    private int id;
    private String nome;
    private char status;

    public Fornecedor(int id, String nome, char status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Fornecedor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        String aux = "";
        aux += status;
        return aux;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    
}
