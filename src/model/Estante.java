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
public class Estante {
    private int id, prateleiraId;
    private String letra;

    public Estante() {
    }
    
    public Estante(int id, int prateleiraId, String letra) {
        this.id = id;
        this.prateleiraId = prateleiraId;
        this.letra = letra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrateleiraId() {
        return prateleiraId;
    }

    public void setPrateleiraId(int prateleiraId) {
        this.prateleiraId = prateleiraId;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
    
    
    
}
