/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.controller;

import com.hatta.webapp.entity.User;
import com.hatta.webapp.service.UserService;
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
    
//    binding from user-register
    @ModelAttribute("user")
    public User construt(){
        return new User();
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
        return "user-register";
    }
}
