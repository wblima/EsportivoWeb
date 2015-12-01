/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;



import br.edu.ifsul.modelo.Entrada;
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
public class EntradaDAO<T> extends GenericDAO<Entrada> implements Serializable{
//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<Entrada> listarTodos;

    public EntradaDAO() {
        super();
        super.setPersistentClass(Entrada.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("data", "Data", "like"));
        super.getListOrder().add(
                new Order("valor", "Valor", "like")); 
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

//    public void persist(Entrada objeto) throws Exception{
//        em.persist(objeto);
//    }
//    
//    public void merge(Entrada objeto) throws Exception{
//        em.merge(objeto);
//    }
//    
//    public void remove(Entrada objeto) throws Exception{
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//
//    public Entrada getObjectById(Integer id) throws Exception{
//        return em.find(Entrada.class, id);
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
//    public List<Entrada> getListarTodos() {
//        return em.createQuery("from Entrada order by id").getResultList();
//    }
//
//    public void setListarTodos(List<Entrada> listarTodos) {
//        this.listarTodos = listarTodos;
//    }
    
    
    
}
