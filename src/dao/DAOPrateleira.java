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
import model.Prateleira;

/**
 *
 * @author raphaela.crwagner
 */
public class DAOPrateleira {

    private Connection conn;

    public DAOPrateleira() {
        conn = ConnectionFactory.getConnection();
    }

    public ArrayList<Prateleira> selectAll() {
        String sql = "Select * from Prateleira";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Prateleira> list = new ArrayList<>();

            while (rs.next()) {
                Prateleira pt = new Prateleira();
                pt.setId(rs.getInt("pt_id"));
                pt.setLetra(rs.getString("pt_Letra").charAt(0));

                list.add(pt);
            }
            ConnectionFactory.closeConnection(conn, stmt, rs);
            return list;
        } catch (SQLException ex) {
            System.err.println("DAO PRATELEIRA: " + ex);
            return null;
        }

    }

}
