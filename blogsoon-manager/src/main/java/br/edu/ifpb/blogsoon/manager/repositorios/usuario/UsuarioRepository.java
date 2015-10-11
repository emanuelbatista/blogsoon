/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.blogsoon.manager.repositorios.usuario;

import br.edu.ifpb.blogsoon.core.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    List<Usuario> findBynome(String nome);
}
