/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tableModels;

import dao.DAOCliente;
import java.util.ArrayList;
import java.util.Arrays;
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
    ArrayList<Float> total = new ArrayList<Float>();
    private Cliente cli;
    
    String[] colunas = {"Codigo", "Produto", "QTD", "Preço","Subtotal"};
    
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
                return total.get(linha);//adicionar .2f para formatar as casas decimais
        }
        return null;
    }
    
    public void addProd(Produto prod, int qtd){
        boolean flag = true;
        for (Produto produto : lista) {
            if(produto.getId() == prod.getId()){
                int pos = lista.indexOf(produto);
                qtdLista.set(pos, qtdLista.get(pos) + qtd);
                flag = false;
            }
        }
        if(flag){
            lista.add(prod);
            qtdLista.add(qtd);
            float aux = prod.getPreco() * (float) qtd;
            total.add(aux);
        }
        fireTableDataChanged();
    }
    
    public void cancelarCompra(){
        lista.clear();
        qtdLista.clear();
        total.clear();
        fireTableDataChanged();
    }

    public ArrayList<Produto> getLista() {
        return lista;
    }

    public ArrayList<Integer> getQtdLista() {
        return qtdLista;
    }
    
    public ArrayList<Float> getTotalLista(){
        return total;
    }
    
    public int quantosEstaoNoCarrinho(Produto prod){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getId() == prod.getId()){
                return qtdLista.get(i);
            }
        }
        return 0;
    }
    
    public void setCliente(Cliente cliente){
        this.cli = cliente;
    }
    
    public Cliente getCliente(){
        return cli;
    }
//    public ArrayList<Integer> getDescontoLista() {
//        return descontoLista;
//    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }
    
    
}
