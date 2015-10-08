package br.edu.ifpb.bdnc.testeneo4j;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) {
        String path = "/home/douglas/Downloads/neo4j-community-2.2.5/data/graph.db";
        GraphDatabaseService graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(path);
        try (Transaction tx = graphDB.beginTx()) {
            //graphDB.schema().constraintFor(DynamicLabel.label("Usuario"))
              //      .assertPropertyIsUnique("id")
                //    .create();

            //Node n = graphDB.createNode(DynamicLabel.label("Usuario"));
            //n.setProperty("id", "Alguma coisa");
            
            Node n1 = graphDB.findNode(DynamicLabel.label("Usuario"), "id", "Alguma coisa");
            Node n2 = graphDB.findNode(DynamicLabel.label("Pessoa"), "nome", "douglas");
            
            n1.createRelationshipTo(n2, RelTypes.AMIGO);
            
            tx.success();
        }
    }
}
