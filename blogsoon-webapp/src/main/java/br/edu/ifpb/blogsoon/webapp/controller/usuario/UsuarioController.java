package br.edu.ifpb.blogsoon.webapp.controller.usuario;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.exceptions.LoginException;
import br.edu.ifpb.blogsoon.manager.repositorios.usuario.UsuarioRepository;
import br.edu.ifpb.blogsoon.manager.servicos.usuario.UsuarioService;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 * @author douglasgabriel
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController{

    @Autowired
    private UsuarioService servico;
    
    @Autowired
    private UsuarioRepository UsuarioRepository;

    @ModelAttribute("usuario")
    public Usuario criarUsuario() {
        return new Usuario();
    }

    @RequestMapping("home")
    public String home(){
       return "home";
    }
    
    @RequestMapping({"login"})
    public String login(HttpServletRequest request) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        try {
            Usuario usuario = servico.login(login, senha);
            request.getSession().setAttribute("usuario", usuario);
            return "redirect:/usuario/home";
        } catch (LoginException e) {
            request.setAttribute("loginErro", e.getMessage());
            return "index";
        }
    }
    
    @RequestMapping("logout")
    public String logout (HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("cadastro")
    public String cadastro(@Valid @ModelAttribute Usuario usuario, BindingResult result) {
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

    @RequestMapping("salvar/imagem")
    public String uploadImagemPerfil(@RequestParam("file") MultipartFile arquivo,
            HttpServletRequest request) {
        System.out.println("Entrando no método para salvar imagem do controlador");
        if (!arquivo.isEmpty()) {
            try {
                Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
                usuario.setFoto(arquivo.getBytes());
                UsuarioRepository.save(usuario);
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
        return "redirect:/usuario/home";
    }
    
    @RequestMapping(value="imagem/perfil",produces = {MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public void getImagemPerfil(HttpServletRequest request,HttpServletResponse response){
        Usuario usuario=(Usuario)request.getSession().getAttribute("usuario");
        try {
            OutputStream out=response.getOutputStream();
            out.write(usuario.getFoto());
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
