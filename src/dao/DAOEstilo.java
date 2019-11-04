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
import model.Estante;
import model.Estilo;

/**
 *
 * @author raphaela.crwagner
 */
public class DAOEstilo {
    private Connection conn;

    public DAOEstilo() {
        conn = ConnectionFactory.getConnection();
    }
    
    public void insert(Estilo estilo) throws SQLException {
        String sql = "INSERT INTO estilo(nome) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, estilo.getNome());
        stmt.execute();
        stmt.close();
    }
    
    public ArrayList<Estilo> selectAll(){
        String sql = "Select * from Estilo";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Estilo> list = new ArrayList<>();
        
            while(rs.next()){
                Estilo et = new Estilo();
                et.setId(rs.getInt("et_id"));
                et.setNome(rs.getString("et_nome"));
                
                list.add(et);
            }
            ConnectionFactory.closeConnection(conn, stmt,rs);
            return list;
        } catch (SQLException ex) { 
           System.err.println("DAO ESTILO: " + ex);
            return null;
        }
        
       
        
        
    }
    
    
}




