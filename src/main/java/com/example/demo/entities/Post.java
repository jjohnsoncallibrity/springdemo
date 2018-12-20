package com.example.demo.entities;

import com.example.demo.audit.CreationAuditable;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post extends CreationAuditable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private Link link;

    private String body;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post parent;

    @OneToMany(mappedBy = "parent")
    private List<Post> children;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public List<Post> getChildren() {
        return children;
    }

    public void setChildren(List<Post> children) {
        this.children = children;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
