/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tableModels;

import dao.DAOCliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Cliente;
import model.Produto;

/**
 *
 * @author rogerio.slucon
 */
public class CarrinhoTableModel extends AbstractTableModel{
    ArrayList<Produto> lista = new ArrayList<Produto>();
    ArrayList<Integer> qtdLista = new ArrayList<Integer>();
//    ArrayList<Integer> descontoLista = new ArrayList<Integer>();
    
    String[] colunas = {"Codigo", "Produto", "QTD", "Preço", "Desconto",
        "Subtotal"};
    
    public CarrinhoTableModel() {
       
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
                return qtdLista.get(linha);
            case 3:
                return lista.get(linha).getPreco();
            case 4:
                return lista.get(linha).getDesconto();
            case 5:
                float aux = lista.get(linha).getPreco() * qtdLista.get(linha);
                aux = aux *(lista.get(linha).getDesconto()/100);
                return lista.get(linha).getPreco();
        }
        return null;
    }
    
    public void addProd(Produto prod, int qtd){
        lista.add(prod);
        qtdLista.add(qtd);
//        descontoLista.add(desc);
        
        fireTableDataChanged();
    }
    
    public void cancelarCompra(){
        lista.clear();
        qtdLista.clear();
//        descontoLista.clear();
        fireTableDataChanged();
    }

    public ArrayList<Produto> getLista() {
        return lista;
    }

    public ArrayList<Integer> getQtdLista() {
        return qtdLista;
    }

//    public ArrayList<Integer> getDescontoLista() {
//        return descontoLista;
//    }
    
    
}
