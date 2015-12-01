/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;



import br.edu.ifsul.dao.FuncionarioDAO;
import br.edu.ifsul.modelo.Funcionario;

import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author William
 */
@ManagedBean(name = "controleFuncionario")
@ViewScoped
public class ControleFuncionario implements Serializable{
    
    @EJB
    private FuncionarioDAO<Funcionario> dao;
    private Funcionario objeto;

    public ControleFuncionario() {
    }
    
    public String listar(){
        return "/privado/funcionario/listar?faces-redirect=true";
    }
    
     public void novo() {
        objeto = new Funcionario();
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

    public FuncionarioDAO getDao() {
        return dao;
    }

    public void setDao(FuncionarioDAO dao) {
        this.dao = dao;
    }

    public Funcionario getObjeto() {
        return objeto;
    }

    public void setObjeto(Funcionario objeto) {
        this.objeto = objeto;
    }
    
    
    
}
