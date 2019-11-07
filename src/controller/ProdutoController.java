package controller;

import dao.DAOProduto;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lojademanga.ProdutoTableModel;
import model.Produto;


/**
 *
 * @author gabriel.mmcarmo
 */
public class ProdutoController {
    
    private static ProdutoController INSTANCE;
    
    private ProdutoTableModel tableModel = new ProdutoTableModel();
    
    public static ProdutoController getProdutoController(){
        if(INSTANCE != null){
            return INSTANCE;
        }else{
            return INSTANCE = new ProdutoController();
        }
    }
}
