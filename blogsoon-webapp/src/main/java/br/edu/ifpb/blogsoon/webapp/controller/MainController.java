package br.edu.ifpb.blogsoon.webapp.controller;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
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

    @ModelAttribute("usuario")
    public Usuario criarUsuario() {
        return new Usuario();
    }
    
    @RequestMapping("/")
    public String index (){
        return "index";
    }
}
