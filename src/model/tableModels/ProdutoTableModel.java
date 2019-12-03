/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tableModels;

import dao.DAOProduto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author gabriel.mmcarmo
 * @see dao.DAOProduto
 * @see model.Produto
 */

public class ProdutoTableModel extends AbstractTableModel{
    ArrayList<Produto> lista = new ArrayList<>();
    
    String[] colunas = {"Codigo", "Drescrição", "Quantidade", "Preço"};

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
    /*@param linha do tipo Inteiro, coluna do tipo Inteiro
      @return Id,Titulo,Quantidade,Preço: se coluna encontrada, null: se não encontrar coluna*/
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
    /*@param prod objeto do tipo Produto*/
    public void addLinha(Produto prod){
        lista.add(prod);
        fireTableDataChanged();
    }
    
    public void atualiza(){
        fireTableDataChanged();
    }
    /*@param list objeto do tipo arrayList*/
    public void setList(ArrayList<Produto> list) {
        this.lista = list;
        fireTableDataChanged();
    }
    
    public void getProd(){
        DAOProduto prod = new DAOProduto();
        lista = prod.selectAll();
    }
    
}
