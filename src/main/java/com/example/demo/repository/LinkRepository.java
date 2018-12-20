package com.example.demo.repository;

import com.example.demo.entities.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LinkRepository extends PagingAndSortingRepository<Link, Long> {

}
