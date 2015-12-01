package br.edu.ifsul.dao;


import br.edu.ifsul.modelo.Conta;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ContaDAO<T> extends GenericDAO<Conta> implements Serializable {

//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<Conta> listarTodos;

    public ContaDAO() {
        super();
        super.setPersistentClass(Conta.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("status", "Status", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(0));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

//    public void persist(Conta objeto) throws Exception{
//        em.persist(objeto);
//    }
//    
//    public void merge(Conta objeto) throws Exception{
//        em.merge(objeto);
//    }
//    
//    public void remove(Conta objeto) throws Exception{
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//
//    public Conta getObjectById(Integer id) throws Exception{
//        return em.find(Conta.class, id);
//    }
//    
//    public EntityManager getEm() {
//        return em;
//    }
//
//    public void setEm(EntityManager em) {
//        this.em = em;
//    }
//
//    public List<Conta> getListarTodos() {
//        return em.createQuery("from Conta").getResultList();
//    }
//
//    public void setListarTodos(List<Conta> listarTodos) {
//        this.listarTodos = listarTodos;
//    }

}
