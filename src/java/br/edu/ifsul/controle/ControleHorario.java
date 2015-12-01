/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.ClienteDAO;
import br.edu.ifsul.dao.HorarioDAO;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Horario;

import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author William
 */
@ManagedBean(name = "controleHorario")
@ViewScoped
public class ControleHorario implements Serializable{
    
    @EJB
    private HorarioDAO<Horario> dao;
    private Horario objeto;
    
    @EJB
    private ClienteDAO<Cliente> cdao;
    

    public ControleHorario() {

    }

    public ClienteDAO<Cliente> getCdao() {
        return cdao;
    }

    public void setCdao(ClienteDAO<Cliente> cdao) {
        this.cdao = cdao;
    }

    

    public String listar() {
        return "/privado/horario/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Horario();
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

    public HorarioDAO getDao() {
        return dao;
    }

    public void setDao(HorarioDAO dao) {
        this.dao = dao;
    }

    public Horario getObjeto() {
        return objeto;
    }

    public void setObjeto(Horario objeto) {
        this.objeto = objeto;
    }  
}
