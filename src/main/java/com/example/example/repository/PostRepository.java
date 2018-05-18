package com.example.example.repository;

import com.example.example.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByOrderByCreatedOnDesc();

    List<Post> findAllByAuthorFirstNameLikeIgnoreCaseOrderByCreatedOnDesc(String firstName);
}
