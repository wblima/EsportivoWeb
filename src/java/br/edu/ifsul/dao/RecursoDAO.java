/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;



import br.edu.ifsul.modelo.Recurso;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author William
 */
@Stateless
public class RecursoDAO<T> extends GenericDAO<Recurso> implements Serializable{
//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<Recurso> listarTodos;

    public RecursoDAO() {
        super();
        super.setPersistentClass(Recurso.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        super.getListOrder().add(
                new Order("localizacao", "Localizacao", "like")); 
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

//    public void persist(Recurso objeto) throws Exception{
//        em.persist(objeto);
//    }
//    
//    public void merge(Recurso objeto) throws Exception{
//        em.merge(objeto);
//    }
//    
//    public void remove(Recurso objeto) throws Exception{
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//
//    public Recurso getObjectById(Integer id) throws Exception{
//        return em.find(Recurso.class, id);
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
//    public List<Recurso> getListarTodos() {
//        return em.createQuery("from Recurso order by nome").getResultList();
//    }
//
//    public void setListarTodos(List<Recurso> listarTodos) {
//        this.listarTodos = listarTodos;
//    }
    
    
    
}
