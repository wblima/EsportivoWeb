
package br.edu.ifsul.converters;




import br.edu.ifsul.modelo.Fornecedor;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * jorge.bavaresco@passofundo.ifsul.edu.br
 */
@FacesConverter(value = "converterFornecedor")
public class ConverterFornecedor implements Serializable, Converter {
    
    @PersistenceContext(unitName = "EsportivoWebPU")
    private EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Fornecedor.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null){
            return null;
        }
        Fornecedor obj = (Fornecedor) o;
        return obj.getId().toString();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
