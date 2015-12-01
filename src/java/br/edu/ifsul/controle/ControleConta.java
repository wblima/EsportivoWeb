package br.edu.ifsul.controle;


import br.edu.ifsul.dao.ContaDAO;
import br.edu.ifsul.modelo.Conta;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "controleConta")
@ViewScoped
public class ControleConta implements Serializable {

    @EJB
    private ContaDAO<Conta> dao;
    private Conta objeto;

    public ControleConta() {

    }

    public String listar() {
        return "/privado/conta/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Conta();
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

    public ContaDAO getDao() {
        return dao;
    }

    public void setDao(ContaDAO dao) {
        this.dao = dao;
    }

    public Conta getObjeto() {
        return objeto;
    }

    public void setObjeto(Conta objeto) {
        this.objeto = objeto;
    }

}
