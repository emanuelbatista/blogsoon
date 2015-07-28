#Blog Soon

Projeto desenvolvido na disciplina de BDNC (Banco de Dados Não-Convencional), que tem um proposito de criar um blog de publicação de artigos, que possuirá quatro bancos de dados nos quais são: Redis, MongoDB, Cassandra, PostgresSQL.

##Pré-Requisitos

###Ferramentas

[Git][], [JDK8][] e [Maven] []

Certifique-se de que seu ambiente `JAVA_HOME` variável aponta para a pasta `jdk1.8.0`
extraído a partir do download do JDK.

###Banco de dados

[MongoDB][], [Cassandra][], [Redis][] e [PostgresSQL][]

##Confira o código fonte

 `git clone git@github.com:emanuelbatista/blogsoon.git`

##Execução 

 `mvn clean spring-boot:run`

##Acessar na máquina local
  
  `localhost:9000`

##Empacotar
  
  `mvn clean package`

##Executar a aplicação pelo .war
  
  `java -jar target/${nome da aplicação}.war`


[Git]: https://github.com/
[JDK8]: http://www.oracle.com/technetwork/java/javase/downloads
[Maven]: https://maven.apache.org/download.cgi
[MongoDB]: https://www.mongodb.org/downloads
[Cassandra]: http://cassandra.apache.org/download/
[Redis]: http://redis.io/download
[PostgresSQL]: http://www.enterprisedb.com/products-services-training/pgdownload


