package br.edu.ifpb.blogsoon.core.entidades.grafo;

import java.util.Objects;
import java.util.Set;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;



/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@NodeEntity(label = "Post")
public class PostGrafo{

    @GraphId
    private Long id;
    @Property
    private String idPost;    
    @Relationship(type = "POSSUI",direction = Relationship.OUTGOING)
    private Set<TagGrafo> tags;

    public PostGrafo() {
    }

    public PostGrafo(String idPost) {
        this.idPost = idPost;
    }

    public PostGrafo(String idPost, Set<TagGrafo> tags) {
        this.idPost = idPost;
        this.tags = tags;
    }
    
    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public Set<TagGrafo> getTags() {
        return tags;
    }

    public void setTags(Set<TagGrafo> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.idPost);
        hash = 41 * hash + Objects.hashCode(this.tags);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PostGrafo other = (PostGrafo) obj;
        if (!Objects.equals(this.idPost, other.idPost)) {
            return false;
        }
        if (!Objects.equals(this.tags, other.tags)) {
            return false;
        }
        return true;
    }
    
    
    
}
