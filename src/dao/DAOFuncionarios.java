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
import model.Funcionarios;

/**
 *
 * @author raphaela.crwagner
 */
public class DAOFuncionarios {
    private Connection conn;

    public DAOFuncionarios() {
        conn = ConnectionFactory.getConnection();
    }
    
    public ArrayList<Funcionarios> selectAll(){
        String sql = "Select * from Funcionarios";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Funcionarios> list = new ArrayList<>();
        
            while(rs.next()){
                Funcionarios func = new Funcionarios();
                func.setId(rs.getInt("func_id"));
                func.setNome(rs.getString("func_nome"));
                
                
                list.add(func);
            }
            ConnectionFactory.closeConnection(conn, stmt,rs);
            return list;
        } catch (SQLException ex) { 
           System.err.println("DAO FUNCIONÁRIOS: " + ex);
            return null;
        }
        
       
        
        
    }
    
    
}







