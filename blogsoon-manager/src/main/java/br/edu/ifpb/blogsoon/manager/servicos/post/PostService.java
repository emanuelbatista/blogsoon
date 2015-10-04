package br.edu.ifpb.blogsoon.manager.servicos.post;

import br.edu.ifpb.blogsoon.core.entidades.Post;
import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import java.util.List;

/**
 *
 * @author douglasgabriel
 */
public interface PostService {
    
    public Post recuperar(String id);
    
    public List<Post> recuperarTodos ();
    
    public List<Post> recuperarTodosPorOrdemDeAvaliacao();
    
    public void salvar (Post post);
    
    public boolean usuarioAvaliouPost (String idPost, Usuario usuario);
}
