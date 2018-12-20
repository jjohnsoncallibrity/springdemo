package com.example.demo.dao;

import com.example.demo.entities.Link;

import java.util.List;

public interface LinkDAO {
    public void save(Link link);

    public Link getLinkById(Long linkId);

    public List<Link> getAllByPageAndOffset(int page, int offset);
}
