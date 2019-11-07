/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojademanga;

import dao.DAOProduto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author gabriel.mmcarmo
 */

public class ProdutoTableModel extends AbstractTableModel{
    ArrayList<Produto> lista = new ArrayList<>();
    
    String[] colunas = {"Codigo", "Drescrição", "Preço", "Quantidade"};

    public ProdutoTableModel() {
    }
    
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
                return lista.get(linha).getQtd();
            case 3:
                return lista.get(linha).getPreco();
        }
        
        return null;
    }
    
    public void addLinha(Produto prod){
        lista.add(prod);
        fireTableDataChanged();
    }
    
    public void atualiza(){
        fireTableDataChanged();
    }
    
    public void setList(ArrayList<Produto> list) {
        this.lista = list;
    }
    
    public void getProd(){
        DAOProduto prod = new DAOProduto();
        lista = prod.selectAll();
    }
    
}
