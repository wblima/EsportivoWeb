/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;


import br.edu.ifsul.modelo.EntradaItens;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author William
 */
@Stateless
public class EntradaItensDAO<T> extends GenericDAO<EntradaItens> implements Serializable{
//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<EntradaItens> listarTodos;

    public EntradaItensDAO() {
        super();
        super.setPersistentClass(EntradaItens.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("quantidade", "Quantidade", "="));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(0));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

//    public void persist(EntradaItens objeto) throws Exception{
//        em.persist(objeto);
//    }
//    
//    public void merge(EntradaItens objeto) throws Exception{
//        em.merge(objeto);
//    }
//    
//    public void remove(EntradaItens objeto) throws Exception{
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//
//    public EntradaItens getObjectById(Integer id) throws Exception{
//        return em.find(EntradaItens.class, id);
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
//    public List<EntradaItens> getListarTodos() {
//        return em.createQuery("from EntradaItens order by id").getResultList();
//    }
//
//    public void setListarTodos(List<EntradaItens> listarTodos) {
//        this.listarTodos = listarTodos;
//    }
    
    
    
}
