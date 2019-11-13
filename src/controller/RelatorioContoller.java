/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOVenda;
import java.util.ArrayList;
import model.Produto;
import model.VendaTemporaria;
import model.tableModels.RelatorioAnaliticoTableModel;

/**
 *
 * @author Rogerio
 */
public class RelatorioContoller {
    private RelatorioAnaliticoTableModel model;
    private VendaTemporaria venda;
    public RelatorioContoller() {
        model = new RelatorioAnaliticoTableModel();
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
                System.out.println("Atualiza qtd");
                qtd++;
            }
        }
        qtdList.add(qtd);
        model.setLista(aux);
        model.setQtdLista(qtdList);
    }
    
    public RelatorioAnaliticoTableModel getModel() {
        return model;
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
    
}
