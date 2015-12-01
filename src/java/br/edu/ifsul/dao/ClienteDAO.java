/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;



import br.edu.ifsul.modelo.Cliente;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author William
 */
@Stateless
public class ClienteDAO<T> extends GenericDAO<Cliente> implements Serializable{
//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<Cliente> listarTodos;

    public ClienteDAO() {
         super();
        super.setPersistentClass(Cliente.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        super.setCurrentOrder((Order) super.getListOrder().get(0));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

//    public void persist(Cliente objeto) throws Exception{
//        em.persist(objeto);
//    }
//    
//    public void merge(Cliente objeto) throws Exception{
//        em.merge(objeto);
//    }
//    
//    public void remove(Cliente objeto) throws Exception{
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//
//    public Cliente getObjectById(Integer id) throws Exception{
//        return em.find(Cliente.class, id);
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
//    public List<Cliente> getListarTodos() {
//        return em.createQuery("from Cliente order by nome").getResultList();
//    }
//
//    public void setListarTodos(List<Cliente> listarTodos) {
//        this.listarTodos = listarTodos;
//    }
    
    
    
}
