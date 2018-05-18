package com.example.example.service;

import com.example.example.entity.Post;
import com.example.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addPost(Post post) {
        this.postRepository.save(post);
    }

    public List<Post> getPosts() {
        return this.postRepository.findAllByOrderByCreatedOnDesc();
    }

    public List<Post> getAuthorPosts(String firstName) {
        return this.postRepository.findAllByAuthorFirstNameLikeIgnoreCaseOrderByCreatedOnDesc(firstName);
    }
}
