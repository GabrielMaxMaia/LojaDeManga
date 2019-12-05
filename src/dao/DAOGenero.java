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
import model.Genero;


/**
 *
 * @author raphaela.crwagner
 * @see model.Genero
 */
public class DAOGenero {
    private Connection conn;

    public DAOGenero() {
        conn = ConnectionFactory.getConnection();
    }
    //@param genero objeto do tipo genero
    public void insert(Genero genero) throws SQLException {
        String sql = "INSERT INTO genero(nome) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, genero.getNome());
        stmt.execute();
        stmt.close();
    }
    //@return genero do tipo Array List se sem erros, null se com erros
    public ArrayList<Genero> selectAll() {
        String sql = "Select * from Genero";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Genero> list = new ArrayList<>();

            while (rs.next()) {
                Genero gen = new Genero();
                gen.setId(rs.getInt("gen_id"));
                gen.setNome(rs.getString("gen_nome"));

                list.add(gen);
            }
            ConnectionFactory.closeConnection(conn, stmt,rs);
            return list;        
        } catch (SQLException ex) {
            System.err.println("DAO GENERO: " + ex);
            return null;
        }

    }

}


