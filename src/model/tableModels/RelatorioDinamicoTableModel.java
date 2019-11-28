/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tableModels;

import dao.DAOItens;
import dao.DAOVenda;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.table.AbstractTableModel;
import model.Venda;


/**
 *
 * @author rogerio.slucon
 */
public class RelatorioDinamicoTableModel extends AbstractTableModel{
    ArrayList<Venda> lista = new ArrayList<>();
    ArrayList<Integer> listaQtd = new ArrayList<>();
    ArrayList<Integer> listaPreco = new ArrayList<>();
    
    String[] colunas = {"Codigo da Venda", "Cliente", "Quantidade de Produtos",
        "Valor da Venda", "Data Venda"};
    
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
                return listaQtd.get(linha); 
            case 3:
                return listaPreco.get(linha);
            case 4:
                return lista.get(linha).getData();
        }
        
        return null;
    }
    
    public void addLinha(Venda prod){
        lista.add(prod);
        fireTableDataChanged();
    }
    
    public void atualiza(){
        getComprar();
        fireTableDataChanged();
    }
    
    public void setList(ArrayList<Venda> list) {
//        this.lista.clear();
//        this.listaPreco.clear();
//        this.listaQtd.clear();
        System.out.println(lista.size());
        this.fireTableRowsDeleted(0, 2);
        this.lista = list;
//        getQtd();
        fireTableDataChanged();
    }
    
    public void getComprar(){
        lista.clear();
        DAOVenda dao = new DAOVenda();
        lista = dao.selectAll();
        getQtd();
    }
    
    public void getQtd(){
        listaQtd.clear();
        for (Venda venda : lista) {
            DAOItens dao = new DAOItens();
            listaQtd.add(dao.calculaQtdItens(venda.getId()));
        }
        getValorTotal();
    }
    
    public void getValorTotal(){
        listaPreco.clear();
        for (Venda venda : lista) {
            DAOVenda dao = new DAOVenda();
            listaPreco.add(dao.calculaValorVenda(venda.getId()));
        }
    }
//    //Temporario
//    public void getComprar(){
//        lista.clear();
//        DAOVenda dao = new DAOVenda();
//        Set<String> keys = dao.getKey();
//        
//        for (String key : keys) {
//            VendaTemporaria venda = dao.getVendaItens(key);
//            venda.setId(key);
//            lista.add(venda);
//        }
//    }
    
    
}
