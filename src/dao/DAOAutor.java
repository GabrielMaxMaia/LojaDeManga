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
import model.Autor;
import model.Cliente;

/**
 *
 * @author raphaela.crwagner
 */
public class DAOAutor {

    private Connection conn;

    public DAOAutor() {
        conn = ConnectionFactory.getConnection();
    }

    public ArrayList<Autor> selectAll() {
        String sql = "Select * from Autor";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Autor> list = new ArrayList<>();

            while (rs.next()) {
                Autor au = new Autor();
                au.setId(rs.getInt("au_id"));
                au.setNome(rs.getString("au_nome"));

                list.add(au);
            }

            return list;
        } catch (SQLException ex) {
            System.err.println("DAO CLIENTE: " + ex);
            return null;
        }

    }

}
