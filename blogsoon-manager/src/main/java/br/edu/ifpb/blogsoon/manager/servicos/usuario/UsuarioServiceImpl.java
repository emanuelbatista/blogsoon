package br.edu.ifpb.blogsoon.manager.servicos.usuario;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.repositorios.usuario.UsuarioRepository;
import javax.inject.Named;
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
    public void salvar(Usuario usuario) {
        repositorio.save(usuario);
    }

}
