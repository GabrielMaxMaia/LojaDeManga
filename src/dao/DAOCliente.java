/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import lojademanga.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Autor;
import model.Cliente;

/**
 *
 * @author raphaela.crwagner
 */
public class DAOCliente {
    private Connection conn;

    public DAOCliente() {
        conn = ConnectionFactory.getConnection();
    }
    
    public void insert(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente(cpf, nome, email, cel, tel, cep, endereco, cidade, bairro,\n" +
"            complemento, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cliente.getCpf());
        stmt.setString(2, cliente.getNome());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getCel());
        stmt.setString(5, cliente.getTel());
        stmt.setString(6, cliente.getCep());
        stmt.setString(7, cliente.getEndereco());
        stmt.setString(8, cliente.getCidade());
        stmt.setString(9, cliente.getBairro());
        stmt.setString(10, cliente.getComplemento());
        stmt.setString(11, cliente.getStatus());
        stmt.execute();
        stmt.close();
    }
    
    public ArrayList<Cliente> selectAll(){
        String sql = "Select * from Cliente";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Cliente> list = new ArrayList<>();
        
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setCpf(rs.getString("cli_cpf"));
                cli.setNome(rs.getString("cli_nome"));
                cli.setEmail(rs.getString("cli_email"));
                cli.setCel(rs.getString("cli_cel"));
                cli.setTel(rs.getString("cli_tel"));
                cli.setCep(rs.getString("cli_cep"));
                cli.setEndereco(rs.getString("cli_endereco"));
                cli.setCidade(rs.getString("cli_cidade"));
                cli.setBairro(rs.getString("cli_bairro"));
                cli.setComplemento(rs.getString("cli_complemento"));
                cli.setStatus(rs.getString("cli_status").charAt(0));

                list.add(cli);
            }
            ConnectionFactory.closeConnection(conn, stmt,rs);
            return list;
        } catch (SQLException ex) { 
           System.err.println("DAO CLIENTE: " + ex);
            return null;
        }
        
       
        
        
    }
    
    
}
