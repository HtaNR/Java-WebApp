/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.controller;

import com.hatta.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Hatta NR
 */
@Controller
@RequestMapping("/users")
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping
    public String users(Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    @RequestMapping("/{id}")
    public String detail(Model model,@PathVariable int id){
        model.addAttribute("user", userService.findOneWithBlogs(id));
        return "user-detail";    
    }
    
     @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable int id){
        userService.delete(id);
        return "redirect:/users.html";
    }
}
