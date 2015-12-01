/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;





import br.edu.ifsul.modelo.VendaItens;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author William
 */
@Stateless
public class VendaItensDAO<T> extends GenericDAO<VendaItens> implements Serializable{
//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<Venda> listarTodos;

    public VendaItensDAO() {
        super();
        super.setPersistentClass(VendaItens.class);
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

//    public void persist(Venda objeto) throws Exception{
//        em.persist(objeto);
//    }
//    
//    public void merge(Venda objeto) throws Exception{
//        em.merge(objeto);
//    }
//    
//    public void remove(Venda objeto) throws Exception{
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//
//    public Venda getObjectById(Integer id) throws Exception{
//        return em.find(Venda.class, id);
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
//    public List<Venda> getListarTodos() {
//        return em.createQuery("from Venda order by id").getResultList();
//    }
//
//    public void setListarTodos(List<Venda> listarTodos) {
//        this.listarTodos = listarTodos;
//    }
    
    
    
}
