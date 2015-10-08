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
@NodeEntity(label = "Tag")
public class TagGrafo {

    @GraphId
    private String nome;
    @Relationship(type = "POSSUI", direction = Relationship.OUTGOING)
    private Set<PostGrafo> posts;

    public TagGrafo() {
    }

    public TagGrafo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<PostGrafo> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostGrafo> posts) {
        this.posts = posts;
    }
    
}
