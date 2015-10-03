package br.edu.ifpb.blogsoon.core.entidades;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.FetchType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


/**
 *
 * @author marciel
 */
public class Post {

    @Id
    private String id;
    private String title;
    private String content;
    @Transient
    @Basic(fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacaos;
    private String authorLogin;
    private List<String> keywords;
    private String resumo;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    
    public Post() {
    }

    public Post(String title, String content, String authorLogin, List<String> keywords, String resumo) {
        this.title = title;
        this.content = content;
        this.authorLogin = authorLogin;
        this.keywords = keywords;
        this.resumo = resumo == null ? "" : resumo;
    }
    
    public String getAuthorLogin() {
        return authorLogin;
    }

    public void setAuthorLogin(String authorLogin) {
        this.authorLogin = authorLogin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Avaliacao> getAvaliacaos() {
        return avaliacaos;
    }

    public void setAvaliacaos(List<Avaliacao> avaliacaos) {
        this.avaliacaos = avaliacaos;
    }

    @Override
    public String toString() {
        return String.format("Post{ id=%s, title=%s, content=%s}", id, title, content);
    }

}
