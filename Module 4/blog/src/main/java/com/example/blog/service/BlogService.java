package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAllBlog(Pageable pageable);

    Blog findBlogById(int id);

    Blog save(Blog blog);

    Blog delete(int id);


        Page<Blog> findByNameContains(String name,Pageable pageable);
    List<Blog> findByNameContains(String name);
}
