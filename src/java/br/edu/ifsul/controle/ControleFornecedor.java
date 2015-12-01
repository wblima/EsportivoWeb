package br.edu.ifsul.controle;


import br.edu.ifsul.dao.FornecedorDAO;
import br.edu.ifsul.modelo.Fornecedor;

import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "controleFornecedor")
@ViewScoped
public class ControleFornecedor implements Serializable {
    
    @EJB
    private FornecedorDAO<Fornecedor> dao;
    private Fornecedor objeto;
    
    
    public ControleFornecedor() {
        
    }
    
    public String listar() {
        return "/privado/fornecedor/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Fornecedor();
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
    
    
    
    public FornecedorDAO getDao() {
        return dao;
    }
    
    public void setDao(FornecedorDAO dao) {
        this.dao = dao;
    }
    
    public Fornecedor getObjeto() {
        return objeto;
    }
    
    public void setObjeto(Fornecedor objeto) {
        this.objeto = objeto;
    }
    
    
}
