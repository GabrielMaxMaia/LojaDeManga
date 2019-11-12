/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tableModels;

import dao.DAOVenda;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.table.AbstractTableModel;
import model.VendaTemporaria;

/**
 *
 * @author rogerio.slucon
 */
public class RelatorioDinamicoTableModel extends AbstractTableModel{
    ArrayList<VendaTemporaria> lista = new ArrayList<>();
    
    String[] colunas = {"Codigo da Venda", "Cliente", "Quantidade de Produtos",
        "Valor da Venda"};
    
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
                return lista.get(linha).getCliente();
            case 2:
                return lista.get(linha).getQtd(); 
            case 3:
                return lista.get(linha).getValor();
        }
        
        return null;
    }
    
    public void addLinha(VendaTemporaria prod){
        lista.add(prod);
        fireTableDataChanged();
    }
    
    public void atualiza(){
        getComprar();
        fireTableDataChanged();
    }
    
    public void setList(ArrayList<VendaTemporaria> list) {
        this.lista = list;
    }
    
    //Temporario
    public void getComprar(){
        lista.clear();
        DAOVenda dao = new DAOVenda();
        Set<String> keys = dao.getKey();
        
        for (String key : keys) {
            VendaTemporaria venda = dao.getVendaItens(key);
            venda.setId(key);
            lista.add(venda);
        }
    }
    
}
