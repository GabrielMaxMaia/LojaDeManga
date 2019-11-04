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
public class EstantePrateleira {
    private int id, estanteId, prateleiraId;

    public EstantePrateleira() {
    }
    
    public EstantePrateleira(int id, int estante, int prateleira) {
        this.id = id;
        this.estanteId = estante;
        this.prateleiraId = prateleira;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstante() {
        return estanteId;
    }

    public void setEstante(int estante) {
        this.estanteId = estante;
    }

    public int getPrateleira() {
        return prateleiraId;
    }

    public void setPrateleira(int prateleira) {
        this.prateleiraId = prateleira;
    }
    
    
}
