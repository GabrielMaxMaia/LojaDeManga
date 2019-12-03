/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tableModels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author Rogerio
 */
public class RelatorioAnaliticoTableModel extends AbstractTableModel{
    ArrayList<Produto> lista = new ArrayList<>();
    ArrayList<Integer> qtdLista = new ArrayList<>();
    
    String[] colunas = {"Codigo do Produto", "Nome do Produto",
        "Valor Produto", "Quantidade", "Valor SubTotal"};
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return lista.get(linha).getId();
            case 1:
                return lista.get(linha).getTitulo();
            case 2:
                return lista.get(linha).getPreco();
            case 3:
                return qtdLista.get(linha); 
            case 4:
                return lista.get(linha).getPreco() * (float) qtdLista.get(linha);
        }
        return null;
    }

    public void setLista(ArrayList<Produto> lista) {
        this.lista = lista;
    }

    public void setQtdLista(ArrayList<Integer> qtdLista) {
        this.qtdLista = qtdLista;
    }   
    
    public float getTotal(){
        float aux = 0;
        
        for (int i = 0; i < lista.size(); i++) {
            aux += lista.get(i).getPreco() * (float) qtdLista.get(i);
        }
        return aux;
    }
}