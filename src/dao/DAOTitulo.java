package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lojademanga.ConnectionFactory;
import model.Titulo;
public class DAOTitulo {
    private Connection conn;
    
    public DAOTitulo(){
        
        conn = ConnectionFactory.getConnection();
    }
public ArrayList<Titulo> selectAll() {
        String sql = "Select * from Produto";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Titulo> list = new ArrayList<>();

            while (rs.next()) {
                Titulo ti = new Titulo();
                ti.setId(rs.getInt("ti_id"));
                ti.setNome("ti_nome");

                list.add(ti);
            }
            ConnectionFactory.closeConnection(conn, stmt, rs);
            return list;
        } catch (SQLException ex) {
            System.err.println("DAO PRODUTO: " + ex);
            return null;
        }

    }

}
