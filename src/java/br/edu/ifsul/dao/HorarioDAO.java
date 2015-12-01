package br.edu.ifsul.dao;


import br.edu.ifsul.modelo.Horario;
import java.io.Serializable;
import javax.ejb.Stateless;

@Stateless
public class HorarioDAO<T> extends GenericDAO<Horario> implements Serializable {

    public HorarioDAO() {
        super();
        super.setPersistentClass(Horario.class);
        // inicializar as ordenações possiveis
        super.getListOrder().add(
                new Order("id", "ID", "="));
        super.getListOrder().add(
                new Order("status", "Status", "like"));
        super.getListOrder().add(
                new Order("inicio", "Inicio", "like")); 
        super.getListOrder().add(
                new Order("fim", "Fim", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializando o filtro 
        super.setFilter("");
        // inicializando o conversor da ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

}
