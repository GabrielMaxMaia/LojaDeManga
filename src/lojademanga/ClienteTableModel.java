/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojademanga;

import dao.DAOCliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author rogerio.slucon
 */
public class ClienteTableModel extends AbstractTableModel{
    ArrayList<Cliente> list = new ArrayList<Cliente>();
    
    String[] colunas = {"Nome", "CPF", "Telefone", "Email"};

    public ClienteTableModel() {
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return list.get(linha).getNome();
            case 1:
                return list.get(linha).getCpf();
            case 2:
                return list.get(linha).getTel();
            case 3:
                return list.get(linha).getEmail();
        }
        
        return null;
    }

    public void setList(ArrayList<Cliente> list) {
        this.list = list;
    }
    
    public void getCli(){
        DAOCliente cli = new DAOCliente();
        list = cli.selectAll();
    }
        
}
