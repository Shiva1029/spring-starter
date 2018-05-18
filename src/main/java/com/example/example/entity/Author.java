package com.example.example.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue
    private BigInteger id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addPost(Post post) {
        posts.add(post);
        post.setAuthor(this);
    }

    public void removePost(Post post) {
        int count = 0;
        for (Post currentPost : this.posts) {
            if (currentPost == post) {
                posts.remove(count);
                post.setAuthor(null);
                break;
            }
            count++;
        }
        posts.remove(post);
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
