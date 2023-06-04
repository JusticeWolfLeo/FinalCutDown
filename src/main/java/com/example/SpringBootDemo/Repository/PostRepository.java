package com.example.SpringBootDemo.Repository;

import com.example.SpringBootDemo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByDateDesc();
    List<Post> findAllByAuthor_Username(String name);
}