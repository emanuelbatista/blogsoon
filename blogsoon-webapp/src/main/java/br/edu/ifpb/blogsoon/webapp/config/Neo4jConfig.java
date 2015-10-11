package br.edu.ifpb.blogsoon.webapp.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Configuration
@ComponentScan("br.edu.ifpb.blogsoon.manager.repositorios.grafo")
@EnableNeo4jRepositories(basePackages = "br.edu.ifpb.blogsoon.manager.repositorios.grafo")
public class Neo4jConfig extends Neo4jConfiguration{

    @Bean
    @Override
    public Neo4jServer neo4jServer() {
        return new RemoteServer("http://localhost:7474","neo4j","123456");
    }

    @Bean
    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("br.edu.ifpb.blogsoon.core.entidades.grafo");
    }

    @Bean
    @Qualifier(value = "neo4jTransation")
    @Override
    public PlatformTransactionManager transactionManager() throws Exception {
        return super.transactionManager(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    
    
    

   

}
