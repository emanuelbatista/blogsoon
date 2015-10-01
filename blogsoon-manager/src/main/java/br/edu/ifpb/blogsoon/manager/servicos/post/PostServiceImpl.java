package br.edu.ifpb.blogsoon.manager.servicos.post;

import br.edu.ifpb.blogsoon.core.entidades.Post;
import br.edu.ifpb.blogsoon.manager.repositorios.post.PostRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.data.domain.Sort;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class PostServiceImpl implements PostService{

    private PostRepository repository;

    @Inject
    public void setRepository(PostRepository repository) {
        this.repository = repository;
    }
    
    public List<Post> recuperarTodos (){
        Sort ordem = new Sort(Sort.Direction.ASC, "title");
        return repository.findAll(ordem);
    }

    @Override
    public void salvar(Post post) {
        repository.save(post);
    }
    
}
