package praticas.exemplo.pratica.jsf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Stateless
public class SimuladorDao {
    
    @PersistenceContext
    EntityManager em;

    public boolean salvar (Pessoa pessoa){
        em.persist(pessoa);
        return true;
    }
    
}
