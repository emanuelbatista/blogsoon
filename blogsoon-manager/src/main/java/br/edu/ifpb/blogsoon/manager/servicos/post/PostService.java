package br.edu.ifpb.blogsoon.manager.servicos.post;

import br.edu.ifpb.blogsoon.core.entidades.Post;
import java.util.List;

/**
 *
 * @author douglasgabriel
 */
public interface PostService {
    
    public Post recuperar(String id);
    
    public List<Post> recuperarTodos ();
    
    public void salvar (Post post);
}
