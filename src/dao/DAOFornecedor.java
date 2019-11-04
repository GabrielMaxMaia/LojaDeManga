/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lojademanga.ConnectionFactory;
import model.Estilo;
import model.Fornecedor;

/**
 *
 * @author raphaela.crwagner
 */
public class DAOFornecedor {
    private Connection conn;

    public DAOFornecedor() {
        conn = ConnectionFactory.getConnection();
    }
    
    public void insert(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO fornecedor(nome, status) VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, fornecedor.getNome());
        stmt.setString(2, fornecedor.getStatus());
        stmt.execute();
        stmt.close();
    }
    
    public ArrayList<Fornecedor> selectAll(){
        String sql = "Select * from Fornecedor";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Fornecedor> list = new ArrayList<>();
        
            while(rs.next()){
                Fornecedor forn = new Fornecedor();
                forn.setId(rs.getInt("for_id"));
                forn.setNome(rs.getString("for_nome"));
                forn.setStatus(rs.getString("for_status").charAt(0));
                
                list.add(forn);
            }
            ConnectionFactory.closeConnection(conn, stmt,rs);
            return list;
        } catch (SQLException ex) { 
           System.err.println("DAO FORNECEDOR: " + ex);
            return null;
        }
        
       
        
        
    }
    
    
}






