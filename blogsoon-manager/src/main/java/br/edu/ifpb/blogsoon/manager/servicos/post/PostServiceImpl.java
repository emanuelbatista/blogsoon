package br.edu.ifpb.blogsoon.manager.servicos.post;

import br.edu.ifpb.blogsoon.core.entidades.AvaliacaoEnum;
import br.edu.ifpb.blogsoon.core.entidades.Post;
import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.core.entidades.grafo.PostGrafo;
import br.edu.ifpb.blogsoon.core.entidades.grafo.TagGrafo;
import br.edu.ifpb.blogsoon.manager.repositorios.grafo.PostGrafoRepository;
import br.edu.ifpb.blogsoon.manager.repositorios.grafo.TagGrafoRepository;
import br.edu.ifpb.blogsoon.manager.repositorios.post.PostRepository;
import br.edu.ifpb.blogsoon.manager.repositorios.post.redis.PostCache;
import br.edu.ifpb.blogsoon.manager.servicos.avaliacao.AvaliacaoService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class PostServiceImpl implements PostService {

    @Inject
    private PostRepository repository;    
    private AvaliacaoService avaliacaoService;
    private PostGrafoRepository postGrafoRepository;
    @Autowired
    private TagGrafoRepository tagGrafoRepository;

    @Inject
    public void setAvaliacaoService(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }
    @Inject
    private PostCache cache;

    @Inject
    public void setRepository(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> recuperarTodos() {
        Sort ordem = new Sort(Sort.Direction.ASC, "title");
        List<Post> posts = repository.findAll(ordem);
        posts.forEach(x -> {
            x.setAvaliacoesPositivas(avaliacaoService.buscarPorIdPostETipo(x.getId(), AvaliacaoEnum.CURTIR));
            x.setAvaliacoesNegativas(avaliacaoService.buscarPorIdPostETipo(x.getId(), AvaliacaoEnum.NAO_CURTIR));
        });
        Collections.sort(posts);
        return posts;
    }

    @Override
    public List<Post> recuperarTodosPorOrdemDeAvaliacao() {
        List<Post> posts = recuperarTodos();
        Collections.sort(posts);
        return posts;
    }

    @Override
    public void salvar(Post post, String... tags) {
        repository.save(post);
        Set<TagGrafo> lista = new HashSet<>();
        for (String s : tags) {
            TagGrafo tg = tagGrafoRepository.findOne(s);
            if (tg == null) {
                tg = new TagGrafo(s);
            }
            lista.add(tg);
        }
        postGrafoRepository.save(new PostGrafo(post.getId(), lista));
    }

    @Override
    public Post recuperar(String id) {
        Post post = repository.findOne(id);
        long tempTotal = System.currentTimeMillis();
        if (cache.hasChave(id)) {
            post = cache.get(id);
        } else {
            post = repository.findOne(id);
            cache.add(post);
        }
        post.setAvaliacoesPositivas(avaliacaoService.buscarPorIdPostETipo(id, AvaliacaoEnum.CURTIR));
        post.setAvaliacoesNegativas(avaliacaoService.buscarPorIdPostETipo(id, AvaliacaoEnum.NAO_CURTIR));
        return post;
    }

    @Override
    public boolean usuarioAvaliouPost(String idPost, Usuario usuario) {
        return avaliacaoService.buscarPorIdPostEUsuario(idPost, usuario).size() >= 1;
    }
    
    public List<Post> recuperarPostsComMesmaTag (Post post){
        Set<PostGrafo> lista = postGrafoRepository.getPostWithSameTag(post.getId());
        List<Post> posts = new ArrayList<>();
        for (PostGrafo pg : lista){
            posts.add(repository.findOne(pg.getId()));
        }
        return posts;
    }

}
