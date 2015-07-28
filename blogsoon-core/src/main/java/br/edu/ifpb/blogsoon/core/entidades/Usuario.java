/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.blogsoon.core.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 */
@Entity
public class Usuario implements Serializable {
     
    @NotEmpty(message = "O nome está vazio")
    private String nome;
    private String sobrenome;
    @Id
    @NotEmpty(message = "O login está vazio")    
    private String login;
    @NotEmpty(message = "A senha está vazia")
    private String senha; 

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String login, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(long id, String nome, String sobrenome, String login, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.login = login;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + ", nome=" + nome + ", sobrenome=" + sobrenome + ", login=" + login + ", senha=" + senha + '}';
    }
    
    
    
    
}
