package br.edu.ifsul.dao;


import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Query;


@Stateless
public class UsuarioDAO<T> extends GenericDAO<Usuario> implements Serializable {

    public UsuarioDAO() {
        super();
        super.setPersistentClass(Usuario.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("login", "Login", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public Usuario getObjectById(Integer id) throws Exception {
        Usuario obj = super.getEm().find(Usuario.class, id);
        // inicializar as coleções pela chamada do método size()        

        return obj;
    }

    public boolean login(String usuario, String senha) {
        Query query = super.getEm()
                .createQuery(
                        "from Usuario where upper(login) = :usuario and "
                        + "upper(senha) = :senha");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario localizaPorNomeUsuario(String usuario) {
        Usuario obj = (Usuario) super.getEm().createQuery("from Usuario where upper(login) = :usuario").
                setParameter("usuario", usuario.toUpperCase()).getSingleResult();
//        obj.getTelefones().size();
//        obj.getDesejos().size();
//        obj.getAcessos().size();      
        return obj;
    }

}
