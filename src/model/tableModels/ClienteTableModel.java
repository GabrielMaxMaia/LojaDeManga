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

/**
 *
 * @author rogerio.slucon
 */
public class ClienteTableModel extends AbstractTableModel{
    ArrayList<Cliente> lista = new ArrayList<Cliente>();
    
    String[] colunas = {"Nome", "CPF", "Telefone", "Email"};

    public ClienteTableModel() {
       
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
      @return Nome,Cpf,tel,Email: se coluna encontrada, null: se não encontrar coluna*/
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return lista.get(linha).getNome();
            case 1:
                return lista.get(linha).getCpf();
            case 2:
                return lista.get(linha).getTel();
            case 3:
                return lista.get(linha).getEmail();
        }
        
        return null;
    }
    
    public void addLinha(Cliente cli){
        lista.add(cli);
        fireTableDataChanged();
    }
    
    public void atualiza(){
        fireTableDataChanged();
    }
    
    public void setList(ArrayList<Cliente> list) {
        this.lista = list;
    }
    
    public void getCli(){
        DAOCliente cli = new DAOCliente();
        lista = cli.selectAll();
    }
          
}
