/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.blogsoon.manager.service.grafo;

import br.edu.ifpb.blogsoon.core.entidades.grafo.PostGrafo;
import br.edu.ifpb.blogsoon.manager.repositorios.grafo.PostGrafoRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 */
@Service
public class PostGrafoService {
    
    @Autowired
    private PostGrafoRepository repository;
    
    public PostGrafo save (PostGrafo postGrafo){
        return repository.save(postGrafo);
    }
    
    public Set<PostGrafo> getPostWithSameTag(String idPost){
        return repository.getPostWithSameTag(idPost);
    }
}
