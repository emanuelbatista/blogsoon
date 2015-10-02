package br.edu.ifpb.blogsoon.webapp.controller.post;

import br.edu.ifpb.blogsoon.core.entidades.Post;
import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.servicos.post.PostService;
import br.edu.ifpb.blogsoon.manager.servicos.usuario.UsuarioService;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.pegdown.PegDownProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author marciel
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    private PostService postService;
    private UsuarioService usuarioService;

    @Inject
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @Inject
    public void setPostService(PostService postService) {
        this.postService = postService;
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public @ResponseBody
    String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload( HttpSession session,
            @RequestParam("title") String title,
            String palavras_chave,
            String resumo,
            @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                PegDownProcessor processor = new PegDownProcessor();
                
                String content = "";
                
                byte[] bytes = file.getBytes();
                BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
                List<String> list = reader.lines().collect(Collectors.toList());
                
                for (String a : list) {
                    content = content.concat(processor.markdownToHtml(a));
                }
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                postService.salvar(new Post(title, content, usuario.getLogin(), Arrays.asList(palavras_chave.split(",")), resumo));
                
                return content;
            } catch (Exception e) {
                return "You failed to upload " + title + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + title + " because the file was empty.";
        }
    }
    
    @RequestMapping("/{id}")
    public String loadPostPage (HttpServletRequest request
            , @PathVariable String id){
        Post post;
        if ((post = postService.recuperar(id)) != null){
            request.setAttribute("post", post);
            request.setAttribute("usuario", usuarioService.recuperar(post.getAuthorLogin()));
            return "/article";
        }
        return "index";
    }
}
