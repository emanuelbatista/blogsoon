/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.blogsoon.webapp.controller.avaliacao;

import br.edu.ifpb.blogsoon.core.entidades.Avaliacao;
import br.edu.ifpb.blogsoon.core.entidades.AvaliacaoEnum;
import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.servicos.avaliacao.AvaliacaoService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 */
@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    
    @Autowired
    private AvaliacaoService avaliacaoService;
    
    @RequestMapping(value="add",method = RequestMethod.POST)
    public void addAvaliacao(@RequestParam("idPost")String idPost,
            @RequestParam("tipo")AvaliacaoEnum tipo,HttpSession session){
        
        Usuario usuario=(Usuario)session.getAttribute("usuario");
        Avaliacao avaliacao=new Avaliacao();
        avaliacao.setIdPost(idPost);
        avaliacao.setUsuario(usuario);
        avaliacao.setTipo(tipo);
        avaliacaoService.salvar(avaliacao);
        
    }
    
    @RequestMapping(value = "total-avaliacao-post")
    public @ResponseBody Long totalAvaliacaoPost(@RequestParam("idPost")String idPost){
        return avaliacaoService.totalAvaliacaoPost(idPost);
    }
    
    @RequestMapping(value = "total-avaliacao-post-tipo")
    public @ResponseBody Long totalAvaliacaoPostPorTipo(@RequestParam("idPost") String idPost,
            @RequestParam("tipo")AvaliacaoEnum tipo){
        return avaliacaoService.totalAvaliacaoPorTipo(idPost, tipo);
    }
}
