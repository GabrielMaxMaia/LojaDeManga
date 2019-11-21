package controller;

import dao.DAOCliente;
import dao.DAOProduto;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Cliente;
import model.tableModels.ProdutoTableModel;
import model.Produto;

/**
 *
 * @author gabriel.mmcarmo
 */

public class ProdutoController {
    
    private static ProdutoController INSTANCE;
    private String erros;
    
    private ProdutoTableModel tableModel = new ProdutoTableModel();
    
    //Padrao de Projeto SINGLETON, garante uma unica instancia dessa classe
    public static ProdutoController getProdutoController(){
        if(INSTANCE != null){
            return INSTANCE;
        }else{
            return INSTANCE = new ProdutoController();
        }
    }
    
    // Métodos de acesso a DAO
    public Produto pesquisaPorId (int id){
        DAOProduto dao = new DAOProduto();
        Produto prod = dao.buscaPorId(id);
        if(prod != null){
            return prod;
        }else{
            return null;
        }
    }
    
    public boolean atualizaProduto(JTextField[] campos){
        Produto prod = validarDados(campos);
        
        if(prod != null){
            DAOProduto dao = new DAOProduto();
            try {
                dao.update(prod);
                tableModel.getProd();
                return true;
            } catch (SQLException ex) {
                System.err.println("PC Erro Atualizar Produto");
                Logger.getLogger(ProdutoController.class.getName())
                        .log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }
    
    public boolean addProduto(JTextField[] campos){
        Produto prod = validarDados(campos);
        
        if(prod != null){
            try {
                DAOProduto dao = new DAOProduto();
                dao.insert(prod);
                tableModel.addLinha(prod);
                return true;
            } catch (SQLException ex) {
                System.err.println("PC Erro addProduto");
                Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
        return false;
    }
    
    public void excluirProduto(JTextField[] campos){
        
    }
    
    //Temporario
    public void lerProdutos(){
        DAOProduto dao = new DAOProduto();
        tableModel.setList(dao.selectAll());
    }
    
    //Getters e Setters
    public ProdutoTableModel getTableModel() {
        return tableModel;
    }
    
    // Método de validação de campos
    public Produto validarDados(JTextField[] campos){
        Produto prod = new Produto();
        String erros = "";
        
        if(!campos[0].getText().trim().equals("")){
            prod.setId(Integer.parseInt(campos[0].getText()));
        }else{
           erros +="\n Campo Código inválido";
        }
//        if(!campos[1].getText().trim().equals("")){
//            prod.setTituloId(Integer.parseInt(campos[1].getText()));
//        }else{
//            erros +="\n - Título Campo Obrigatorio";
//        }
        if(!campos[1].getText().trim().equals("")){
            prod.setTitulo(campos[1].getText());
        }else{
            erros +="\n Campo Título inválido";
        }
//        if(!campos[2].getText().trim().equals("")){
//            prod.setAutorId(Integer.parseInt(campos[2].getText()));
//        }else{
//            erros +="\n - Autor Campo Obrigatorio"; 
//        }
        if(!campos[2].getText().trim().equals("")){
            prod.setAutor(campos[2].getText());
        }else{
            erros +="\n Campo Autor inválido"; 
        }
//        if(!campos[3].getText().trim().equals("")){
//            prod.setFornecedorId(Integer.parseInt(campos[3].getText()));
//        }else{
//            erros +="\n - Fornecedor Campo Obrigatorio";
//        }
//        if(!campos[4].getText().trim().equals("")){
//            prod.setGeneroId(Integer.parseInt(campos[4].getText()));
//        }else{
//            erros +="\n - Gênero Campo Obrigatorio";
//        }
        if(!campos[5].getText().trim().equals("")){
            prod.setPreco(Float.parseFloat(campos[5].getText()));
        }
//        if(!campos[6].getText().trim().equals("")){
//            prod.setEstanteId(Integer.parseInt(campos[6].getText()));
//        }else{
//            erros +="\n - Estante Obrigatorio"; 
//        }
//        if(!campos[7].getText().trim().equals("")){
//            prod.setPrateleiraId(Integer.parseInt(campos[6].getText()));
//        }else{
//            erros +="\n - Prateleira Campo Obrigatorio";  
//        }
//        if(!campos[8].getText().trim().equals("")){
//            prod.setEdicao(Integer.parseInt(campos[7].getText()));
//        }else{
//            erros +="\n - Edição Campo Obrigatorio";
//        }
//        if(!campos[10].getText().trim().equals("")){
//            prod.setEstiloId(Integer.parseInt(campos[8].getText()));
//        }else{
//            erros +="\n - Estilo Campo Obrigatorio"; 
//        }
//        if(!campos[9].getText().trim().equals("")){
//            prod.setStatus(campos[9].getText());
//        }
        if(!campos[11].getText().trim().equals("")){
            prod.setQtd(Integer.parseInt(campos[11].getText()));
        }
        
        prod.setStatus("A");
        
        this.erros = erros;
        
        if(erros.equals("")){
            return prod;
        }else{
            erros = "Campos Obrigatorios: \n" + erros;
            return null;
        }
    }
    
    public boolean filtrarPorTitulo(String nome){
        DAOProduto dao = new DAOProduto();
        ArrayList<Produto> lista = new ArrayList<>();
        lista = dao.buscaPorTitulo(nome);
        if(!lista.isEmpty()){
            tableModel.setList(lista);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean filtrarPorId(String id){
        int aux = Integer.parseInt(id);
        DAOProduto dao = new DAOProduto();
        Produto prod = dao.buscaPorId(aux);
        if(prod != null){
            ArrayList<Produto> lista = new ArrayList<>();
            lista.add(prod);
            tableModel.setList(lista);
            tableModel.atualiza();
            return true;
        }else{
            return false;
        }
    }

    public String getErros() {
        String aux = erros;
        erros = "";
        return aux;
    }
    
    public void listaCompleta(){
        tableModel.getProd();
    }
}