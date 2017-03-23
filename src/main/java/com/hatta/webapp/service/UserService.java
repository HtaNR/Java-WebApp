/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;

import com.hatta.webapp.entity.Blog;
import com.hatta.webapp.entity.Item;
import com.hatta.webapp.entity.Role;
import com.hatta.webapp.entity.User;
import com.hatta.webapp.repository.BlogRepository;
import com.hatta.webapp.repository.ItemRepository;
import com.hatta.webapp.repository.RoleRepository;
import com.hatta.webapp.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hatta NR
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RoleRepository roleRepository;
            
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(int id) {
        return userRepository.findOne(id);
    }
    @Transactional
    public User findOneWithBlogs(int id) {
        User user = findOne(id);
        List<Blog> blogs = blogRepository.findByUser(user);
        for(Blog blog :blogs){
            List<Item> items =itemRepository.findByBlog(blog, new PageRequest(0,10,Sort.Direction.DESC,"publishDate"));
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
        
    }

    public void save(User user) {
        user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);
        
        userRepository.save(user);
        
        
    }

    public User findOneWithBlogs(String name) {
        User user = userRepository.findByName(name);
        return findOneWithBlogs(user.getId());
    }
}
