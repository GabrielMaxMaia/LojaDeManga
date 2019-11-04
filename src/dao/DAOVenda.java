package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lojademanga.ConnectionFactory;
import model.Venda;

public class DAOVenda {
    private Connection conn;
    
    public DAOVenda(){
        
        conn = ConnectionFactory.getConnection();
    }
public ArrayList<Venda> selectAll() {
        String sql = "Select * from Produto";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Venda> list = new ArrayList<>();

            while (rs.next()) {
                Venda ve = new Venda();
                ve.setId(rs.getInt("ve_id"));
                ve.setFuncionarios(rs.getInt("ve_funcionario"));
                ve.setCliente(rs.getInt("ve_cliente"));
                

                list.add(ve);
            }
            ConnectionFactory.closeConnection(conn, stmt, rs);
            return list;
        } catch (SQLException ex) {
            System.err.println("DAO PRODUTO: " + ex);
            return null;
        }

    }

}
