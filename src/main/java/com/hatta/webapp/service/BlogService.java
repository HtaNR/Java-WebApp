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
import org.springframework.beans.factory.annotation.Autowired;
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
    
}
