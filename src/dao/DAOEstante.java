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
import model.Cliente;
import model.Estante;

/**
 *
 * @author raphaela.crwagner
 */
public class DAOEstante {
    private Connection conn;

    public DAOEstante() {
        conn = ConnectionFactory.getConnection();
    }
    
    public ArrayList<Estante> selectAll(){
        String sql = "Select * from Estante";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Estante> list = new ArrayList<>();
        
            while(rs.next()){
                Estante es = new Estante();
                es.setId(rs.getInt("ep_id"));
                es.setLetra(rs.getString("es_letra"));
                es.setPrateleiraId(rs.getInt("es_prateleira"));

                list.add(es);
            }
            
            return list;
        } catch (SQLException ex) { 
           System.err.println("DAO CLIENTE: " + ex);
            return null;
        }
        
       
        
        
    }
    
    
}


