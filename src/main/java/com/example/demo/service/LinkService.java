package com.example.demo.service;

import com.example.demo.entities.Link;

import java.util.List;

public interface LinkService {
    public void save(Link link);

    public Link getLinkById(Long linkId);

    public List<Link> getAllByPageAndOffset(int page, int offset);
}
