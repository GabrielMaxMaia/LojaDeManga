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
import model.Itens;

/**
 *
 * @author raphaela.crwagner
 */
public class DAOItens {
    private Connection conn;

    public DAOItens() {
        conn = ConnectionFactory.getConnection();
    }

    public ArrayList<Itens> selectAll() {
        String sql = "Select * from Itens";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Itens> list = new ArrayList<>();

            while (rs.next()) {
                Itens cp = new Itens();
                cp.setProduto(rs.getInt("cp_produto"));
                cp.setCompras(rs.getInt("cp_compras"));
                list.add(cp);
            }
            
            ConnectionFactory.closeConnection(conn, stmt,rs);
            return list;        
        } catch (SQLException ex) {
            System.err.println("DAO ITENS: " + ex);
            return null;
        }

    }

}



