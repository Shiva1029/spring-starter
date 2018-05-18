package com.example.example.service;

import com.example.example.entity.Author;
import com.example.example.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(Author author) {
        this.authorRepository.save(author);
    }

    public Author getAuthor(BigInteger id) { return this.authorRepository.findAuthorById(id); }

    public List<Author> getAuthors() {
        return this.authorRepository.findAll();
    }
}
