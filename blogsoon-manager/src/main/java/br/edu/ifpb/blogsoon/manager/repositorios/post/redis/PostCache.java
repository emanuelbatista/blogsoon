package br.edu.ifpb.blogsoon.manager.repositorios.post.redis;

import br.edu.ifpb.blogsoon.core.entidades.Post;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Repository
public class PostCache {
    
    private Jedis jedis;
    private Gson gson;

    public PostCache() {
        this.jedis=new Jedis("localhost", 6379);
        this.gson=new Gson();
    }
    
    public boolean add(Post post){
        jedis.append(post.getId(), gson.toJson(post));
        jedis.expire(post.getId(), 30*60);
        return true;
    }
    
    public Post get(String chave){
        return gson.fromJson(jedis.get(chave), Post.class);
    }
    
    public boolean hasChave(String chave){
        return jedis.exists(chave);
    }
    
            
}
