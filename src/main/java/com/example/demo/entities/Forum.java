package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Forum {
    @Id
    @GeneratedValue
    Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forum")
    List<Link> links;

    private String path;

    private String forumName;

    private String forumDesc;

    public Forum() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getForumDesc() {
        return forumDesc;
    }

    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }

}
