package br.edu.ifpb.blogsoon.webapp.controller;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Controller
@RequestMapping("/")
@SessionAttributes("usuario")
public class MainController {

    @RequestMapping("/")
    public String index (Model model){
        model.addAttribute("usuario", new Usuario());
        return "index";
    }
}
