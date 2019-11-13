/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOCliente;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.tableModels.ClienteTableModel;
import model.Cliente;

/**
 *
 * @author raphaela.crwagner
 */
public class ClienteController {   
    private static ClienteController INSTANCE;
    
    private ClienteTableModel tableModel = new ClienteTableModel();
    private String erros;
    
//    private String cpfSelecionado = "";
    
    //Padrao de Projeto SINGLETON, garante uma unica instancia dessa classe
    public static ClienteController getClienteController(){
        if(INSTANCE != null){
            return INSTANCE;
        }else{
            return INSTANCE = new ClienteController();
        }
    }
    
    public ClienteController() {
        lerClientes();
    }
    
    //Metodos de acesso a DAO
    public void pesquisaPorNome(String nome){
        
    }
    
    public Cliente pesquisaPorCpf(String Cpf){
        DAOCliente dao = new DAOCliente();
        Cliente cli = dao.buscarPorCpf(Cpf);
        if(cli != null){
            return cli;
        }else{
            return null;
        }
    }
    
    public void atualizaCliente(JTextField[] campos){
        Cliente cli = validarDados(campos);
        if(cli != null){
            DAOCliente dao = new DAOCliente();
            try {
                dao.update(cli);
                tableModel.getCli();
            } catch (SQLException ex) {
                System.err.println("CC Erro Atualizar Cliente");
                Logger.getLogger(ClienteController.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean addCliente(JTextField[] campos){
        Cliente cli = validarDados(campos);
        
        if(cli != null){
            try {
                DAOCliente dao = new DAOCliente();
                dao.insert(cli);
                tableModel.addLinha(cli);
                return true;
            } catch (SQLException ex) {
                System.err.println("CC Erro addCliente");
                Logger.getLogger(ClienteController.class.getName())
                        .log(Level.SEVERE, null, ex);
                return false;
            }
        } 
        return false;
    }
    
    public Cliente validarDados(JTextField[] campos){
        Cliente cli = new Cliente();
        erros = "";
        
        if(!campos[0].getText().trim().equals("")){
            cli.setCpf(campos[0].getText());
        }else{
            erros +="\n - Cpf";
            campos[0].setBackground(Color.red);
        }
        if(!campos[1].getText().trim().equals("")){
            cli.setNome(campos[1].getText());
        }else{
            erros +="\n - Nome";
            campos[1].setBackground(Color.red);
        }
        if(!campos[2].getText().trim().equals("")){
            cli.setEmail(campos[2].getText());
        }else{
            erros +="\n - E-mail"; 
            campos[2].setBackground(Color.red);
        }
        if(!campos[3].getText().trim().equals("")){
            cli.setCel(campos[3].getText());
        }else{
            erros +="\n - Celular";
            campos[3].setBackground(Color.red);
        }
        if(!campos[4].getText().trim().equals("")){
            cli.setTel(campos[4].getText());
        }else{
            erros +="\n - Telefone";
            campos[4].setBackground(Color.red);
        }
        if(!campos[5].getText().trim().equals("")){
            cli.setCep(campos[5].getText());
        }else{
            erros +="\n - CEP"; 
            campos[5].setBackground(Color.red);
        }
        if(!campos[6].getText().trim().equals("")){
            cli.setEndereco(campos[6].getText());
        }else{
            erros +="\n - Endereço";  
            campos[6].setBackground(Color.red);
        }
        if(!campos[7].getText().trim().equals("")){
            cli.setCidade(campos[7].getText());
        }else{
            erros +="\n - Cidade";
            campos[7].setBackground(Color.red);
        }
        if(!campos[8].getText().trim().equals("")){
            cli.setBairro(campos[8].getText());
        }else{
            erros +="\n - Bairro"; 
            campos[8].setBackground(Color.red);
        }if(!campos[9].getText().trim().equals("")){
            cli.setComplemento(campos[9].getText());
        }
        
        cli.setStatus("A");
        
        if(erros.equals("")){
            return cli;
        }else{
            erros = "Campos Obrigatorios: \n" + erros;
            return null;
        }
    }
    
    //Temporario
    public void lerClientes(){
        DAOCliente dao = new DAOCliente();
        tableModel.setList(dao.selectAll());
    }
    
    //Getters e Setters
    public ClienteTableModel getTableModel() {
        return tableModel;
    }
    
    public String getErros(){
        String aux = erros;
        erros = "";
        return aux;
    }
    
    public boolean filtrarPorNome(String nome){
        DAOCliente dao = new DAOCliente();
        ArrayList<Cliente> lista = new ArrayList<>();
        lista = dao.buscaPorNome(nome);
        if(!lista.isEmpty()){
            tableModel.setList(lista);
            tableModel.atualiza();
            return true;
        }else{
            return false;
        }
    }
    
    public boolean filtrarPorCPF(String cpf){
        DAOCliente dao = new DAOCliente();
        Cliente cli = dao.buscarPorCpf(cpf);
        if(cli != null){
            ArrayList<Cliente> lista = new ArrayList<>();
            lista.add(cli);
            tableModel.setList(lista);
            tableModel.atualiza();
            return true;
        }else{
            return false;
        }
    }
//    public void setCpfSelecionado(String cpf){
//        cpfSelecionado = cpf;
//    }
//    
//    public String getCpfSelecionado(){
//        String aux = cpfSelecionado;
//        cpfSelecionado = "";
//        return aux;
//    }
    
}
