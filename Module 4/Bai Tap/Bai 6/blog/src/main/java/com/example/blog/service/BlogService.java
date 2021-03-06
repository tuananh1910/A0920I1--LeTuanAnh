package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAllBlog(Pageable pageable);
    Blog findBlogById(int id);
    void save(Blog blog);
    void delete(int id);


    Page<Blog> findByNameContains(String name,Pageable pageable);
}
