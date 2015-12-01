/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.EntradaDAO;
import br.edu.ifsul.modelo.Entrada;
import br.edu.ifsul.modelo.EntradaItens;

import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author William
 */
@ManagedBean(name = "controleEntrada")
@ViewScoped
public class ControleEntrada implements Serializable{
    
    @EJB
    private EntradaDAO<Entrada> dao;
    private Entrada objeto;
    private EntradaItens entradaItens;
    private Boolean novaEntrada;

    public ControleEntrada() {
    }
    
    public String listar(){
        return "/privado/entrada/listar?faces-redirect=true";
    }
    
     public void novo() {
        objeto = new Entrada();
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

    public EntradaDAO getDao() {
        return dao;
    }

    public void setDao(EntradaDAO dao) {
        this.dao = dao;
    }

    public Entrada getObjeto() {
        return objeto;
    }

    public void setObjeto(Entrada objeto) {
        this.objeto = objeto;
    }

    public EntradaItens getEntradaItens() {
        return entradaItens;
    }

    public void setEntradaItens(EntradaItens entradaItens) {
        this.entradaItens = entradaItens;
    }
    
     public void novoEntradaItens() {
        entradaItens = new EntradaItens();
        novaEntrada = true;
    }
    
    public void alterarEntradaItem(int index) {
        entradaItens = objeto.getEntradaItens().get(index);
        novaEntrada = false;
    }    
    
    public void salvarEntradaItens() {
        if (novaEntrada) {
            objeto.adicionarEntradaItens(entradaItens);
        }
        Util.mensagemInformacao("Entrada de Itens adicionado com sucesso");
    }    
    
    public void removerEntradaItens(int index) {
        objeto.removerEntradaItens(index);
        Util.mensagemInformacao("Entrada de Itens removido com sucesso");
    } 
    
    
}
