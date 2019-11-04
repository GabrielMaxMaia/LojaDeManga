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
    public void insert(Titulo titulo) throws SQLException {
        String sql = "INSERT INTO titulo() VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, titulo.getId());
        stmt.setString(2, titulo.getNome());
        stmt.execute();
        stmt.close();
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
            System.err.println("DAO Titulo: " + ex);
            return null;
        }

    }

}
