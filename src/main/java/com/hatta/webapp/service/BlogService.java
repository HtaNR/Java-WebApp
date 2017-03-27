/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;

import com.hatta.webapp.entity.Blog;
import com.hatta.webapp.entity.User;
import com.hatta.webapp.repository.BlogRepository;
import com.hatta.webapp.repository.UserRepository;
import static javax.swing.text.html.HTML.Tag.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hatta NR
 */
@Service
public class BlogService {
    
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
    
    public void save(Blog blog, String name) {
        User user =userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
    }
    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }

    public Blog findOne(int id) {
        return blogRepository.findOne(id);
    }
    
}
