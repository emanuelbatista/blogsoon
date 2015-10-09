package br.edu.ifpb.blogsoon.webapp.controller;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.servicos.post.PostService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
public class MainController {

    private PostService postService;

    @Inject
    public void setPostService(PostService postService) {
        this.postService = postService;
    }
    
    @ModelAttribute("usuario")
    public Usuario criarUsuario() {
        return new Usuario();
    }
    
    @RequestMapping("/")
    public String index (HttpServletRequest request){        
        request.setAttribute("posts", postService.recuperarTodos());        
        return "index";
    }
}
