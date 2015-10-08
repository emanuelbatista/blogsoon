package praticas.exemplo.pratica.jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named("gerenciadorUsuario")
@SessionScoped
public class GerenciadorUsuario implements Serializable{

    private Pessoa pessoa;
    
    @EJB
    private SimuladorDao dao;

    public GerenciadorUsuario() {
        this.pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public String resultado(){
        if (dao.salvar(pessoa))
            return "resultado";
        else return null;
    }
    
}
