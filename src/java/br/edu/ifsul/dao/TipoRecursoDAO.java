/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;



import br.edu.ifsul.modelo.TipoRecurso;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author William
 */
@Stateless
public class TipoRecursoDAO<T> extends GenericDAO<TipoRecurso> implements Serializable{
//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<TipoRecurso> listarTodos;

    public TipoRecursoDAO() {
        super();
        super.setPersistentClass(TipoRecurso.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

//    public void persist(TipoRecurso objeto) throws Exception{
//        em.persist(objeto);
//    }
//    
//    public void merge(TipoRecurso objeto) throws Exception{
//        em.merge(objeto);
//    }
//    
//    public void remove(TipoRecurso objeto) throws Exception{
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//
//    public TipoRecurso getObjectById(Integer id) throws Exception{
//        return em.find(TipoRecurso.class, id);
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
//    public List<TipoRecurso> getListarTodos() {
//        return em.createQuery("from TipoRecurso order by id").getResultList();
//    }
//
//    public void setListarTodos(List<TipoRecurso> listarTodos) {
//        this.listarTodos = listarTodos;
//    }
    
    
    
}
