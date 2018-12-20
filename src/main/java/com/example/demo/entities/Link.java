package com.example.demo.entities;

import com.example.demo.audit.CreationAuditable;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;

@Entity
public class Link extends CreationAuditable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "forum_id")
    private Forum forum;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    @NotNull(message = "Please enter a title.")
    @NotEmpty(message = "Please enter a title.")
    private String title;

    @URL(message = "Please enter a valid url or leave blank for self post")
    private String uri;

    private Integer score;

    public Link() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getDomainName() throws URISyntaxException {
        URI domainUri = new URI(getUri());
        String domain = domainUri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

}
