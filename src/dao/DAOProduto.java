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
    
    //Métodos CRUD
    
    public void insert(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto(titulo, autor, fornecedor, genero, preco, estante, prateleira, edicao, status, estilo) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, produto.getTituloId());
        stmt.setInt(2, produto.getAutorId());
        stmt.setInt(3, produto.getFornecedorId());
        stmt.setInt(4, produto.getGeneroId());
        stmt.setFloat(5, produto.getPreco());
        stmt.setInt(6, produto.getEstanteId());
        stmt.setInt(7, produto.getPrateleiraId());
        stmt.setInt(8, produto.getEdicao());
        stmt.setString(9, produto.getStatus());
        stmt.setInt(10, produto.getEstiloId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void update(Produto produto) throws SQLException{
        
        String sql = "Update Produto set pd_preco = ?, pd_titulo = ?,"
                + " pd_autor = ?, pd_quantidade = ?,"
                + " WHERE pd_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setFloat(1, produto.getPreco());
        stmt.setString(2, produto.getTitulo());
        stmt.setString(3,produto.getAutor());
        stmt.setInt(4,produto.getQtd());
        stmt.executeUpdate();
        stmt.close();
        
    }
    
    // Métodos de busca
    
    public Produto buscaPorId(int id){
        String sql = "Select * from Produto where id = " + id;
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                Produto prod = new Produto();
                prod.setId(rs.getInt("pd_id"));
                prod.setTitulo(rs.getString("pd_titulo"));
                prod.setAutor(rs.getString("pd_autor"));
                prod.setQtd(rs.getInt("pd_quantidade"));
                prod.setPreco(rs.getFloat("pd_preco"));
                //prod.setStatus(rs.getString("prod_status"));

                ConnectionFactory.closeConnection(conn, stmt,rs);
                return prod;
            } else{
                System.out.println("Sem resultado");
                return null;
            }
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<Produto> selectAll() {
        String sql = "Select * from Produto";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Produto> list = new ArrayList<>();

            while (rs.next()) {
                Produto prod = new Produto();
                prod.setId(rs.getInt("pd_id"));
                prod.setTitulo(rs.getString("pd_titulo"));
                prod.setAutor(rs.getString("pd_autor"));
                prod.setQtd(rs.getInt("pd_quantidade"));
                prod.setPreco(rs.getFloat("pd_preco"));
//                prod.setTituloId(rs.getInt("pd_titulo"));
//                prod.setAutorId(rs.getInt("pd_autor"));
//                prod.setFornecedorId(rs.getInt("pd_fornecedor"));
//                prod.setGeneroId(rs.getInt("pd_genero"));
//                prod.setPreco(rs.getFloat("pd_preco"));
//                prod.setEstanteId(rs.getInt("pd_estante"));
//                prod.setPrateleiraId(rs.getInt("pd_prateleira"));
//                prod.setEdicao(rs.getInt("pd_edicao"));
//                prod.setStatus(rs.getString("pd_status"));
//                prod.setEstiloId(rs.getInt("pd_estilo"));

                list.add(prod);
            }
            ConnectionFactory.closeConnection(conn, stmt, rs);
            return list;
        } catch (SQLException ex) {
            System.err.println("DAO PRODUTO: " + ex);
            return null;
        }

    }

}


