package br.edu.ifpb.blogsoon.manager.repositorios.post;

import br.edu.ifpb.blogsoon.core.entidades.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author marciel
 */
public interface PostRepository extends MongoRepository<Post, String> {

    public Post findPostByTitle(String title);

}
