/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.blogsoon.manager.service.grafo;

import br.edu.ifpb.blogsoon.core.entidades.grafo.TagGrafo;
import br.edu.ifpb.blogsoon.manager.repositorios.grafo.TagGrafoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 */
@Service
@Transactional
public class TagGrafoService {
    
    private TagGrafoRepository repository;
    
    public TagGrafo findOne(String id){
        return repository.findOne(id);
    }
}
