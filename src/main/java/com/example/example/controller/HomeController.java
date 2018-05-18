package com.example.example.controller;

import com.example.example.entity.Author;
import com.example.example.entity.Post;
import com.example.example.service.AuthorService;
import com.example.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addPost/{authorId}")
    public String add(@RequestBody Post post, @RequestParam(name = "authorId") BigInteger authorId) {
        Author author = this.authorService.getAuthor(authorId);
        // TODO: if(author == null) {}
        post.setAuthor(author);
        post.setCreatedOn(new Date());
        this.postService.addPost(post);
        return "Success";
    }

    @PostMapping("/addAuthor")
    public String add(@RequestBody Author author) {
        this.authorService.addAuthor(author);
        return "Success";
    }

    @GetMapping("/authors")
    public List<Author> authors() {
        return this.authorService.getAuthors();
    }

    @GetMapping("/posts")
    public List<Post> posts() {
        return this.postService.getPosts();
    }

    @GetMapping("/posts/{authorName}")
    public List<Post> posts(@RequestParam(name = "authorName") String authorName) {
        return this.postService.getAuthorPosts(authorName);
    }
}
