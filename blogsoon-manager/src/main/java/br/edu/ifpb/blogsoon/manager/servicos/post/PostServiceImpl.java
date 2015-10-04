package br.edu.ifpb.blogsoon.manager.servicos.post;

import br.edu.ifpb.blogsoon.core.entidades.AvaliacaoEnum;
import br.edu.ifpb.blogsoon.core.entidades.Post;
import br.edu.ifpb.blogsoon.manager.repositorios.post.PostRepository;
import br.edu.ifpb.blogsoon.manager.servicos.avaliacao.AvaliacaoService;
import java.util.Collections;
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

    @Inject
    private PostRepository repository;
    @Inject
    private AvaliacaoService avaliacaoService;

    @Inject
    public void setRepository(PostRepository repository) {
        this.repository = repository;
    }
    
    public List<Post> recuperarTodos (){
        Sort ordem = new Sort(Sort.Direction.ASC, "title");
        List<Post> posts=repository.findAll(ordem);
        posts.forEach(x->{
            x.setAvaliacoesPositivas(avaliacaoService.buscarPorIdPostETipo(x.getId(), AvaliacaoEnum.CURTIR));
            x.setAvaliacoesNegativas(avaliacaoService.buscarPorIdPostETipo(x.getId(), AvaliacaoEnum.NAO_CURTIR));
        });
        return posts;
    }
    
    @Override
    public List<Post> recuperarTodosPorOrdemDeAvaliacao(){
        List<Post> posts = recuperarTodos();
        Collections.sort(posts);
        return posts;
    }

    @Override
    public void salvar(Post post) {
        repository.save(post);
    }

    @Override
    public Post recuperar(String id) {
        Post post=repository.findOne(id);
        post.setAvaliacoesPositivas(avaliacaoService.buscarPorIdPostETipo(id, AvaliacaoEnum.CURTIR));
        post.setAvaliacoesNegativas(avaliacaoService.buscarPorIdPostETipo(id, AvaliacaoEnum.NAO_CURTIR));
        return post;
    }
    
}
