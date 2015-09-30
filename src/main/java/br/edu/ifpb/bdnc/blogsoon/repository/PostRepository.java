package br.edu.ifpb.bdnc.blogsoon.repository;

import br.edu.ifpb.bdnc.blogsoon.bean.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author marciel
 */
public interface PostRepository extends MongoRepository<Post, String> {

    public Post findPostByTitle(String title);

}
