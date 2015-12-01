/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;



import br.edu.ifsul.modelo.Produto;
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
public class ProdutoDAO<T> extends GenericDAO<Produto> implements Serializable{
//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<Produto> listarTodos;

    public ProdutoDAO() {
        super();
        super.setPersistentClass(Produto.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        super.getListOrder().add(
                new Order("estoque", "estoque", "=")); 
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

//    public void persist(Produto objeto) throws Exception{
//        em.persist(objeto);
//    }
//    
//    public void merge(Produto objeto) throws Exception{
//        em.merge(objeto);
//    }
//    
//    public void remove(Produto objeto) throws Exception{
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//
//    public Produto getObjectById(Integer id) throws Exception{
//        return em.find(Produto.class, id);
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
//    public List<Produto> getListarTodos() {
//        return em.createQuery("from Produto order by nome").getResultList();
//    }
//
//    public void setListarTodos(List<Produto> listarTodos) {
//        this.listarTodos = listarTodos;
//    }
//    
    
    
}
