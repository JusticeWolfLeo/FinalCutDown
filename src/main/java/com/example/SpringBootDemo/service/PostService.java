package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.Repository.PostRepository;
import com.example.SpringBootDemo.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPostsSortedByDate() {
        return postRepository.findAllByOrderByDateDesc();
    }

    public List<Post> getPostsByUsername(String name) {
        return postRepository.findAllByauthorname(name);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
