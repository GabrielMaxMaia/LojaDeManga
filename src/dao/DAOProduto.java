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
import model.Produto;


/**
 *
 * @author raphaela.crwagner
 */
public class DAOProduto {
    private Connection conn;

    public DAOProduto() {
        conn = ConnectionFactory.getConnection();
    }

    public ArrayList<Produto> selectAll() {
        String sql = "Select * from Produto";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Produto> list = new ArrayList<>();

            while (rs.next()) {
                Produto pd = new Produto();
                pd.setId(rs.getInt("pd_id"));
                pd.setTituloId(rs.getInt("pd_titulo"));
                pd.setAutorId(rs.getInt("pd_autor"));
                pd.setFornecedorId(rs.getInt("pd_fornecedor"));
                pd.setGeneroId(rs.getInt("pd_genero"));
                pd.setPreco(rs.getFloat("pd_preco"));
                pd.setEstanteId(rs.getInt("pd_estante"));
                pd.setPrateleiraId(rs.getInt("pd_prateleira"));
                pd.setEdicao(rs.getInt("pd_edicao"));
                pd.setStatus(rs.getString("pd_status").charAt(0));
                pd.setEstiloId(rs.getInt("pd_estilo"));

                list.add(pd);
            }
            ConnectionFactory.closeConnection(conn, stmt, rs);
            return list;
        } catch (SQLException ex) {
            System.err.println("DAO PRODUTO: " + ex);
            return null;
        }

    }

}


