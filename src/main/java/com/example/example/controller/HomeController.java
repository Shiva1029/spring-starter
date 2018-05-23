package com.example.example.controller;

import com.example.example.entity.Author;
import com.example.example.entity.Post;
import com.example.example.service.AuthorService;
import com.example.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
public class HomeController {
    private PostService postService;
    private AuthorService authorService;

    @Autowired
    public HomeController(PostService postService, AuthorService authorService) {
        this.postService = postService;
        this.authorService = authorService;
    }

    @RequestMapping("/")
    public String home() {
        return "";
    }

    @PostMapping("/addAuthor")
    public String add(@RequestBody Author author) {
        this.authorService.addAuthor(author);
        return "Success";
    }

    @RequestMapping("/addPost/{authorId}")
    public String add(@RequestBody Post post, @PathVariable(name = "authorId") BigInteger authorId) {
        Author author = this.authorService.getAuthor(authorId);
        // TODO: if(author == null) {}
        post.setAuthor(author);
        post.setCreatedOn(new Date());
        this.postService.addPost(post);
        return "Success";
    }

    @GetMapping("/authors")
    public List<Author> authors() {
        List<Author> authors = this.authorService.getAuthors();
        if(authors == null || authors.size() == 0) {
            throw new EntityNotFoundException();
        } else {
            return authors;
        }
    }

    @GetMapping("/posts")
    public List<Post> posts() {
        List<Post> posts = this.postService.getPosts();
        if(posts == null || posts.size() == 0) {
            throw new EntityNotFoundException();
        } else {
            return posts;
        }
    }

    @GetMapping("/posts/{authorName}")
    public List<Post> posts(@PathVariable(name = "authorName") String authorName) throws EntityNotFoundException {
        List<Post> posts = this.postService.getAuthorPosts(authorName);
        if(posts == null || posts.size() == 0) {
            throw new EntityNotFoundException();
        } else {
            return posts;
        }
    }
}
