package br.edu.ifpb.blogsoon.manager.servicos.usuario;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.exceptions.LoginException;
import javax.persistence.PersistenceException;


/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public interface UsuarioService {

    void salvar (Usuario usuario)  throws PersistenceException;
    Usuario login  (String login, String senha) throws LoginException;
}
