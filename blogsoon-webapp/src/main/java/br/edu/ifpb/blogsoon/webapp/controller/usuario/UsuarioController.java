package br.edu.ifpb.blogsoon.webapp.controller.usuario;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.exceptions.LoginException;
import br.edu.ifpb.blogsoon.manager.servicos.usuario.UsuarioService;
import javax.servlet.http.HttpServletRequest;
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
 * @author douglasgabriel
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
    public String login(HttpServletRequest request) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        try{
            Usuario usuario = servico.login(login, senha);
            request.getSession().setAttribute("usuario", usuario);
            return "index";
        }catch (LoginException e){
            request.setAttribute("loginErro", e.getMessage());
            return "index";
        }
    }

    @RequestMapping("/cadastro")
    public String cadastro(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        try {
            servico.salvar(usuario);
        } catch (Exception e) {
            result.addError(new ObjectError("signup", e.getMessage()));
            return "index";
        }
        return "redirect:/";
    }

}
