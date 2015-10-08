package br.edu.ifpb.blogsoon.core.entidades.grafo;

import java.util.Set;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@NodeEntity(label = "Post")
public class PostGrafo {

    @GraphId
    private String id;    
    @Relationship(type = "POSSUI", direction = Relationship.OUTGOING)
    private Set<TagGrafo> tags;

    public PostGrafo() {
    }

    public PostGrafo(String id) {
        this.id = id;
    }

    public PostGrafo(String id, Set<TagGrafo> tags) {
        this.id = id;
        this.tags = tags;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<TagGrafo> getTags() {
        return tags;
    }

    public void setTags(Set<TagGrafo> tags) {
        this.tags = tags;
    }
    
}
