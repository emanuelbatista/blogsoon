package br.edu.ifpb.blogsoon.manager.repositorios.grafo;

import br.edu.ifpb.blogsoon.core.entidades.grafo.PostGrafo;
import java.util.Set;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author douglasgabriel
 */
@Repository
public interface PostGrafoRepository extends GraphRepository<PostGrafo>{
    
    @Query("MATCH (((p:Post){id={0}}-[:POSSUI]->(m:Tag))-[r:POSSUI]->((p1:Post))) return p1 LIMIT 10")
    Set<PostGrafo> getPostWithSameTag (String postId);
    
}
