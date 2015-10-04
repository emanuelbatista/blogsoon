/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.blogsoon.manager.servicos.avaliacao;

import br.edu.ifpb.blogsoon.core.entidades.Avaliacao;
import br.edu.ifpb.blogsoon.core.entidades.AvaliacaoEnum;
import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import br.edu.ifpb.blogsoon.manager.repositorios.avaliacao.AvaliacaoRepository;
import com.sun.media.sound.AlawCodec;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 */
@Service
public class AvaliacaoService {
    
    @Autowired
    private AvaliacaoRepository repository;
    
    public Avaliacao recuperar(Long id){
        return repository.findOne(id);
    }
    
    public Avaliacao salvar(Avaliacao avaliacao){
        return repository.save(avaliacao);
    }
    
    public long totalAvaliacaoPost(String idPost){
        return repository.totalAvaliacaoPost(idPost);
    }
    
    public long totalAvaliacaoPorTipo(String idPost,AvaliacaoEnum tipo){
        return repository.totalAvaliacaoPostPorTipo(idPost, tipo);
    }
    
    public List<Avaliacao> buscarPorIdPost(String idPost){
        return repository.findAvaliacaoByIdPost(idPost);
    }
    
    public List<Avaliacao> buscarPorIdPostETipo (String idPost, AvaliacaoEnum tipo){
        return repository.findAvaliacaoByIdPostAndTipo(idPost, tipo);
    }
    
    public List<Avaliacao> buscarPorIdPostEUsuario (String idPost, Usuario usuario){
        return repository.findAvaliacaoByIdPostAndUsuario(idPost, usuario);
    }

}
