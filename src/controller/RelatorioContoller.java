/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOVenda;
import java.util.ArrayList;
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
    private VendaTemporaria venda;
    
    public RelatorioContoller() {
        analitico = new RelatorioAnaliticoTableModel();
        dinamico = new RelatorioDinamicoTableModel();
        
        
    }
    
    public void puxaVenda(String idVenda){
        DAOVenda dao = new DAOVenda();
        VendaTemporaria venda = dao.getVendaItens(idVenda);
        if(venda != null){
            atualizaRelatorio(venda);
        }else{

        }
        
    }
    
    public void atualizaRelatorio(VendaTemporaria venda){
        this.venda = venda;
        ArrayList<Produto> vendaProd = venda.getProdutos();
        ArrayList<Produto> aux = new ArrayList<Produto>();
        ArrayList<Integer> qtdList = new ArrayList<Integer>();
        Produto prod = null;
        int qtd = 1;
        for (Produto produto : vendaProd) {
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
    
    public RelatorioAnaliticoTableModel getModel() {
        return analitico;
    }
    
    public String getCPF(){
        return venda.getCliente();
    }
    public String getId(){
        return venda.getId();
    }
    public String getTotal(){
        return Float.toString(venda.getValor());
    }
    
    public void filtrarPorData(String dataInicio, String dataFinal){
        ArrayList<Venda> lista = new ArrayList<>();
        //Lista recebe da dao Vendas
        if(lista != null){
            dinamico.setList(lista);
        }
        
    }
}
