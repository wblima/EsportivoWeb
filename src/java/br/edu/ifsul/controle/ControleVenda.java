/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.VendaDAO;
import br.edu.ifsul.modelo.Venda;
import br.edu.ifsul.modelo.VendaItens;

import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author William
 */
@ManagedBean(name = "controleVenda")
@ViewScoped
public class ControleVenda implements Serializable{
    
    @EJB
    private VendaDAO<Venda> dao;
    private Venda objeto;
    private VendaItens vendaItens;
    private Boolean novoItem;

    public ControleVenda() {
    }
    
    public String listar(){
        return "/privado/venda/listar?faces-redirect=true";
    }
    
     public void novo() {
        objeto = new Venda();
    }
    
    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + e.getMessage());
        }
    }
    
    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
        }
    }
    
    public void remover(Integer id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + e.getMessage());
        }
    }
    
     public void novoVendaItens() {
        vendaItens = new VendaItens();
        novoItem = true;
    }
    
    public void alterarVendaItem(int index) {
        vendaItens = objeto.getVendaItens().get(index);
        novoItem = false;
    }    
    
    public void salvarVendaItens() {
        if (novoItem) {
            objeto.adicionarVendaItens(vendaItens);
        }
        Util.mensagemInformacao("Venda de Itens adicionado com sucesso");
    }    
    
    public void removerVendaItens(int index) {
        objeto.removerVendaItens(index);
        Util.mensagemInformacao("Venda de Itens removido com sucesso");
    } 

    public VendaDAO getDao() {
        return dao;
    }

    public void setDao(VendaDAO dao) {
        this.dao = dao;
    }

    public Venda getObjeto() {
        return objeto;
    }

    public void setObjeto(Venda objeto) {
        this.objeto = objeto;
    }

    public VendaItens getVendaItens() {
        return vendaItens;
    }

    public void setVendaItens(VendaItens vendaItens) {
        this.vendaItens = vendaItens;
    }

    public Boolean getNovoItem() {
        return novoItem;
    }

    public void setNovoItem(Boolean novoItem) {
        this.novoItem = novoItem;
    }
    
    
    
}
