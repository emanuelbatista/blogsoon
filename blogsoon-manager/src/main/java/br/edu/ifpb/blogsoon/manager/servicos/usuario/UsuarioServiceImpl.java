package br.edu.ifpb.blogsoon.manager.servicos.usuario;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.exceptions.LoginException;
import br.edu.ifpb.blogsoon.manager.repositorios.usuario.UsuarioRepository;
import javax.inject.Named;
import javax.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repositorio;
    
    @Override
    public void salvar(Usuario usuario) throws PersistenceException{
        if (repositorio.findOne(usuario.getLogin()) != null)
            throw new PersistenceException("O login informado já foi cadastrado");
        repositorio.save(usuario);
    }

    @Override
    public Usuario login(String login, String senha) throws LoginException{
        Usuario usuario;
        if ((usuario = repositorio.findOne(login)) != null){
            if (usuario.getSenha().equals(senha))
                return usuario;
            else{
                throw new LoginException("Senha inválida");
            }
        }else{
            throw new LoginException("Login inválido");
        }
    }

}
