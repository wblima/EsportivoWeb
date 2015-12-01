/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Funcionario;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author William
 */
@Stateless
public class FuncionarioDAO<T> extends GenericDAO<Funcionario> implements Serializable {
//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<Funcionario> listarTodos;

    public FuncionarioDAO() {
        super();
        super.setPersistentClass(Funcionario.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        super.getListOrder().add(
                new Order("horaEntrada", "HoraEntrada", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }
}

//    public void persist(Funcionario objeto) throws Exception{
//        em.persist(objeto);
//    }
//    
//    public void merge(Funcionario objeto) throws Exception{
//        em.merge(objeto);
//    }
//    
//    public void remove(Funcionario objeto) throws Exception{
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//
//    public Funcionario getObjectById(Integer id) throws Exception{
//        return em.find(Funcionario.class, id);
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
//    public List<Funcionario> getListarTodos() {
//        return em.createQuery("from Funcionario order by nome").getResultList();
//    }
//
//    public void setListarTodos(List<Funcionario> listarTodos) {
//        this.listarTodos = listarTodos;
//    }

