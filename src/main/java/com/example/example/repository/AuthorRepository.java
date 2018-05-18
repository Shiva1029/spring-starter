package com.example.example.repository;

import com.example.example.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, BigInteger> {
    List<Author> findAll();

    Author findAuthorById(BigInteger id);
}
