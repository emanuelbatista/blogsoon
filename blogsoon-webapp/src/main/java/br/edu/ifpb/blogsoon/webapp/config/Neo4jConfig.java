package br.edu.ifpb.blogsoon.webapp.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Configuration
@EnableNeo4jRepositories
public class Neo4jConfig extends Neo4jConfiguration{

    @Bean
    @Override
    public Neo4jServer neo4jServer() {
        return new RemoteServer("http://localhost:7474","neo4j","123");
    }

    @Bean
    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("br.edu.ifpb.blogsson");
    }

    

   

}
