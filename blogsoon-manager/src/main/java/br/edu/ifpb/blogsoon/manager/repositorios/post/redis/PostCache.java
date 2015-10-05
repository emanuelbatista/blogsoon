package br.edu.ifpb.blogsoon.manager.repositorios.post.redis;

import redis.clients.jedis.Jedis;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class PostChache {
    
    Jedis jedis = new Jedis("localhost", 10000);
            
}
