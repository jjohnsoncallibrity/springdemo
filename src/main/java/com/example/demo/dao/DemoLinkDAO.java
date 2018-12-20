package com.example.demo.dao;

import com.example.demo.entities.Link;
import com.example.demo.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoLinkDAO implements LinkDAO {

    private LinkRepository linkRepository;

    @Autowired
    public DemoLinkDAO(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public void save(Link link) {
        linkRepository.save(link);
    }

    @Override
    public Link getLinkById(Long linkId) {
        return linkRepository.findById(linkId).orElse(null);
    }

    @Override
    public List<Link> getAllByPageAndOffset(int page, int offset) {
        return linkRepository.findAll(PageRequest.of(page, offset)).getContent();
    }

}
