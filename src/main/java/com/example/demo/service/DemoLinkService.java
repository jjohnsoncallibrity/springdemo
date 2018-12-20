package com.example.demo.service;

import com.example.demo.dao.LinkDAO;
import com.example.demo.entities.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoLinkService implements LinkService {

    private LinkDAO linkDAO;

    @Autowired
    public DemoLinkService(LinkDAO linkDAO) {
        this.linkDAO = linkDAO;
    }

    @Override
    public void save(Link link) {
        linkDAO.save(link);
    }

    @Override
    public Link getLinkById(Long linkId) {
        return linkDAO.getLinkById(linkId);
    }

    @Override
    public List<Link> getAllByPageAndOffset(int page, int offset) {
        return linkDAO.getAllByPageAndOffset(page, offset);
    }
}
