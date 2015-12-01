package br.edu.ifsul.dao;




import br.edu.ifsul.modelo.Fornecedor;
import java.io.Serializable;
import javax.ejb.Stateless;


@Stateless
public class FornecedorDAO<T> extends GenericDAO<Fornecedor> implements Serializable {

//    @PersistenceContext(unitName = "EsportivoWebPU")
//    private EntityManager em;
//    private List<Fornecedor> listarTodos;

    public FornecedorDAO() {
        super();
        super.setPersistentClass(Fornecedor.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("nome", "Nome", "like"));
        super.getListOrder().add(
                new Order("cnpj", "CNPJ", "like")); 
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));

    }

//    public void persistir(Fornecedor objeto) throws Exception {
//        em.persist(objeto);
//    }
//
//    public void merge(Fornecedor objeto) throws Exception {
//        em.merge(objeto);
//    }
//
//    public void remover(Fornecedor objeto) throws Exception {
//        objeto = em.merge(objeto);
//        em.remove(objeto);
//    }
//    
//    public Fornecedor getObjectById(Integer id) throws Exception {
//        return (Fornecedor) em.find(Fornecedor.class, id);
//    }
//
//    public List<Fornecedor> getListarTodos() {
//        return em.createQuery("from Fornecedor order by id").getResultList();
//    }
//
//    public void setListarTodos(List<Fornecedor> listarTodos) {
//        this.listarTodos = listarTodos;
//    }
//
//    public EntityManager getEm() {
//        return em;
//    }
//
//    public void setEm(EntityManager em) {
//        this.em = em;
//    }

}
