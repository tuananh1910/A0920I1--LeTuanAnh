package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;


    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {

        return blogRepository.findAll(pageable);
//        return crudRepository.findAll(pageable);
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog delete(int id) {
        blogRepository.deleteById(id);
        return findBlogById(id);
    }

    @Override
    public Page<Blog> findByNameContains(String name, Pageable pageable) {
        return blogRepository.findByNameContains(name,pageable);
    }
}
