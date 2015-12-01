/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.TipoRecursoDAO;
import br.edu.ifsul.modelo.TipoRecurso;

import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author William
 */
@ManagedBean(name = "controleTipoRecurso")
@ViewScoped
public class ControleTipoRecurso implements Serializable{
    
    @EJB
    private TipoRecursoDAO<TipoRecurso> dao;
    private TipoRecurso objeto;

    public ControleTipoRecurso() {
    }
    
    public String listar(){
        return "/privado/tipoRecurso/listar?faces-redirect=true";
    }
    
     public void novo() {
        objeto = new TipoRecurso();
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

    public TipoRecursoDAO getDao() {
        return dao;
    }

    public void setDao(TipoRecursoDAO dao) {
        this.dao = dao;
    }

    public TipoRecurso getObjeto() {
        return objeto;
    }

    public void setObjeto(TipoRecurso objeto) {
        this.objeto = objeto;
    }
    
    
    
}
