package lojademanga;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rogerio
 */
public class ConnectionFactory {
//    private static final String DRIVER = "com,mysql.jdbc.Driver";
    private static String nomeBD = "MangaStore";
    private static final String URL = "jdbc:mysql://localhost:3307/" + nomeBD; 
    private static final String USER = "root"; 
    private static final String PASS = ""; 

    public static Connection getConnection() {
        
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexao", ex);
        }   
    }
    
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro de conexao " + ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro de conexao " + ex);
            }
        }
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro de conexao(con,stmt,rs) " + ex);
            }
        }
        closeConnection(con,stmt);    
    }
    
}
