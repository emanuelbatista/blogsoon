/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.blogsoon.webapp.controller.usuario;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.servicos.usuario.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService servico;

    @ModelAttribute("usuario")
    public Usuario criarUsuario() {
        return new Usuario();
    }

    @RequestMapping({"/login"})
    public String login() {
        return "index";
    }

    @RequestMapping("/cadastro")
    public String cadastro(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro";
        }
        try {
            servico.salvar(usuario);
        } catch (Exception e) {
            result.addError(new ObjectError("Login", "O login informado já foi cadastrado"));
            return "cadastro";
        }
        return "redirect:/login";
    }

}
