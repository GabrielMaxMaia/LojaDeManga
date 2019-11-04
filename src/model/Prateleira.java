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
public class Prateleira {
    private int id, numeroPrateleira;

    public Prateleira() {
    }

    public Prateleira(int id, int numeroPrateleira) {
        this.id = id;
        this.numeroPrateleira = numeroPrateleira;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroPrateleira() {
        return numeroPrateleira;
    }

    public void setNumeroPrateleira(int numeroPrateleira) {
        this.numeroPrateleira = numeroPrateleira;
    }
    
    
}
