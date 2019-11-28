/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOVenda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;
import model.Venda;
import model.VendaTemporaria;
import model.tableModels.RelatorioAnaliticoTableModel;
import model.tableModels.RelatorioDinamicoTableModel;

/**
 *
 * @author Rogerio
 */
public class RelatorioContoller {
    private RelatorioAnaliticoTableModel analitico;
    private RelatorioDinamicoTableModel dinamico;
    private Venda venda;
    
    public RelatorioContoller() {
        analitico = new RelatorioAnaliticoTableModel();
        dinamico = new RelatorioDinamicoTableModel();
        
        
    }
    
    public void puxaVenda(String idVenda){
        DAOVenda dao = new DAOVenda();
        Venda venda = dao.pegarVendaItens(idVenda);
        if(venda != null)
            atualizaRelatorio(venda);
    }
        
    public void atualizaRelatorio(Venda venda){
        this.venda = venda;
        ArrayList<Produto> vendaListaProd = venda.getListaProdutos();
        ArrayList<Produto> aux = new ArrayList<Produto>();
        ArrayList<Integer> qtdList = new ArrayList<Integer>();
        Produto prod = null;
        int qtd = 1;
        for (Produto produto : vendaListaProd) {
            if(prod == null){
                prod = produto;
                aux.add(prod);
            }else if(produto.getTitulo() != prod.getTitulo()){
                prod = produto;
                aux.add(prod);
                qtdList.add(qtd);
                qtd = 1;
            }else{
                qtd++;
            }
        }
        qtdList.add(qtd);
        analitico.setLista(aux);
        analitico.setQtdLista(qtdList);
    }
//    
    public RelatorioAnaliticoTableModel getModelAnalitica() {
        return analitico;
    }
    
    public String getCPF(){
        return venda.getCliente();
    }
    public int getId(){
        return venda.getId();
    }
    public Float getTotal(){
        return venda.getValor();
    }
    
    public void filtrarPorData(String dataInicio, String dataFinal){
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        Date dataI ,dataF;
        try {
            dataI = formatar.parse(dataInicio);
            dataF = formatar.parse(dataFinal);
            
            java.sql.Date dataSQLI = new java.sql.Date(dataI.getTime());
            java.sql.Date dataSQLF = new java.sql.Date(dataF.getTime());
            
            ArrayList<Venda> lista = new ArrayList<>();
            //Lista recebe da dao Vendas
            DAOVenda ve = new DAOVenda();
            lista = ve.PesqData(dataSQLI, dataSQLF);
            if(lista != null){
                dinamico.setList(lista);
            }
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioContoller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
