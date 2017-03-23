/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.controller;


import com.hatta.webapp.entity.Blog;
import com.hatta.webapp.entity.User;
import com.hatta.webapp.service.BlogService;
import com.hatta.webapp.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hatta NR
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;
            
//    binding from user-register
    @ModelAttribute("user")
    public User construtUser(){
        return new User();
    }
    
     @ModelAttribute("blog")
    public Blog construtBlog(){
        return new Blog();
    }
    
    @RequestMapping("/users")
    public String users(Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    @RequestMapping("/users/{id}")
    public String detail(Model model,@PathVariable int id){
        model.addAttribute("user", userService.findOneWithBlogs(id));
        return "user-detail";    
    }
    @RequestMapping("/register")
    public String showRegister(){
        return "user-register";
    }
//    getting user after submit button
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/register.html?succes=true";
    }
//   getting user data specificaly
    @RequestMapping("/account")
    public String account(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("user", userService.findOneWithBlogs(name));
        return"user-detail";
    }
    
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal){
        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account.html";
    }
}
