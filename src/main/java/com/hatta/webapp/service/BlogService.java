/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;

import com.hatta.webapp.entity.Blog;
import com.hatta.webapp.entity.Item;
import com.hatta.webapp.entity.User;
import com.hatta.webapp.exception.RssException;
import com.hatta.webapp.repository.BlogRepository;
import com.hatta.webapp.repository.ItemRepository;
import com.hatta.webapp.repository.UserRepository;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RssService rssService;
    
    public void saveItems(Blog blog){
        try {
            List<Item> items = rssService.getitems(blog.getUrl());
            for (Item item : items) {
                Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
                if (savedItem ==  null){
                    item.setBlog(blog);
                    itemRepository.save(item);
                }
                
            }
        } catch (RssException ex) {
            ex.printStackTrace();
        }
    }
    
    public void save(Blog blog, String name) {
        User user =userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
        saveItems(blog);
    }
    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }

    public Blog findOne(int id) {
        return blogRepository.findOne(id);
    }
    
}
