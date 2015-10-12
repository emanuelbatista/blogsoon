package br.edu.ifpb.blogsoon.manager.repositorios.grafo;

import br.edu.ifpb.blogsoon.core.entidades.grafo.TagGrafo;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author douglasgabriel
 */
@Repository
public interface TagGrafoRepository extends GraphRepository<TagGrafo>{

    @Query("MATCH (t:Tag {nome : {0}}) return t")
    TagGrafo findOne (String nome);
    
}
