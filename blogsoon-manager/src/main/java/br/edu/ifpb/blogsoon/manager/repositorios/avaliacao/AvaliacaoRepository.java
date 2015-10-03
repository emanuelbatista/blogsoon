/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.blogsoon.manager.repositorios.avaliacao;

import br.edu.ifpb.blogsoon.core.entidades.Avaliacao;
import br.edu.ifpb.blogsoon.core.entidades.AvaliacaoEnum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 */
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long>{
    
    @Query("SELECT COUNT(a) FROM Avaliacao a WHERE a.idPost=:idPost")
    public long totalAvaliacaoPost(@Param("idPost")String idPost);
    
    @Query("SELECT COUNT(a) FROM Avaliacao a WHERE a.idPost=:idPost AND a.tipo=:tipo")
    public long totalAvaliacaoPostPorTipo(@Param("idPost")String idPost,@Param("tipo")AvaliacaoEnum tipo);
}
