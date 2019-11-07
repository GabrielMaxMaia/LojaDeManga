package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import lojademanga.ConnectionFactory;
import model.Venda;

public class DAOVenda {
    private Connection conn;
    //Temporario
    private HashMap<String, ArrayList> listaVenda = new HashMap<String, ArrayList>();
    private HashMap<String, String> listaCliente = new HashMap<>();
    private HashMap<String, String> listaData = new HashMap<>();
    
    public DAOVenda(){
        
        conn = ConnectionFactory.getConnection();
    }
    public void insert(Venda venda) throws SQLException {
        String sql = "INSERT INTO venda() VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, venda.getCliente());
        stmt.setInt(2, venda.getFuncionarios());
        stmt.execute();
        stmt.close();
    }
public ArrayList<Venda> selectAll() {
        String sql = "Select * from Venda";

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
            System.err.println("DAO Venda: " + ex);
            return null;
        }

    }
    // Temporarior
    public void gerarVenda(String idVenda, String cpf, String data,
            ArrayList listaProd){
        listaVenda.put(idVenda, listaProd);
        listaCliente.put(idVenda, cpf);
        listaData.put(idVenda, data);    
    }
    
    public ArrayList getVendaItens(String idVenda){
        return listaVenda.get(idVenda);
    }
    
    public String getVendaCpf(String idVenda){
        return listaCliente.get(idVenda);
    }
    
    public String getVendaData(String idVenda){
        return listaData.get(idVenda);
    }
    
}
