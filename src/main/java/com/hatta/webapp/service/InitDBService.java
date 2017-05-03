/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;

import com.hatta.webapp.entity.Blog;
import com.hatta.webapp.entity.Role;
import com.hatta.webapp.entity.User;
import com.hatta.webapp.repository.BlogRepository;
import com.hatta.webapp.repository.ItemRepository;
import com.hatta.webapp.repository.RoleRepository;
import com.hatta.webapp.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Hatta NR
 */
@Transactional
@Service
public class InitDBService {
    @Autowired
    private RoleRepository roleReposiroty;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ItemRepository itemRepository;
    
    @PostConstruct
    public void init(){
        if(roleReposiroty.findByName("ROLE_ADMIN")==null){
//        buat role user
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleReposiroty.save(roleUser);
        
//        buat role admin
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleReposiroty.save(roleAdmin);
        
//        buat user admin
        User userAdmin = new User();
        userAdmin.setEnabled(true);
        userAdmin.setName("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       
        userAdmin.setPassword(encoder.encode("admin"));
        List<Role> roles = new ArrayList<Role>();

//        admin punya 2 role
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        
//        save user admin to repo
        userRepository.save(userAdmin);
        
//        make blog and save it
        Blog blogWebapp = new Blog();
        blogWebapp.setName("WebApp");
        blogWebapp.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogWebapp.setUser(userAdmin);
        
        blogRepository.save(blogWebapp);
        
//        make item 1 dan 2
//        Item item1 = new Item();
//        item1.setBlog(blogWebapp);
//        item1.setTitle("First");
//        item1.setLink("http://www.google.com");
//        item1.setPublishDate(new Date());
//        itemRepository.save(item1);
//        
//        Item item2 = new Item();
//        item2.setBlog(blogWebapp);
//        item2.setTitle("Second");
//        item2.setLink("http://www.google.com");
//        item2.setPublishDate(new Date());
//        itemRepository.save(item2);
        }
    }
}
