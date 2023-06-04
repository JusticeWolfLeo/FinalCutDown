package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Post;
import com.example.SpringBootDemo.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        List<Post> posts = postService.getAllPostsSortedByDate();
        model.addAttribute("posts", posts);
        return "all-posts";
    }

    @GetMapping("/my-posts")
    public String getMyPosts(Model model, Principal principal) {
        String username = principal.getName();
        List<Post> myPosts = postService.getPostsByUsername(username);
        model.addAttribute("myPosts", myPosts);
        return "my-posts";
    }

}
