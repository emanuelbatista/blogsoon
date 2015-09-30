package br.edu.ifpb.bdnc.blogsoon.bean;

import org.springframework.data.annotation.Id;

/**
 *
 * @author marciel
 */
public class Post {

    @Id
    private String id;
    private String title;
    private String content;

    public Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return String.format("Post{ id=%s, title=%s, content=%s}", id, title, content);
    }

}
