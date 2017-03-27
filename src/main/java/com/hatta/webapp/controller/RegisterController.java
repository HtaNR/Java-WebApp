/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.controller;

import com.hatta.webapp.entity.User;
import com.hatta.webapp.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hatta NR
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    
    @Autowired
    private UserService userService;
    
    //    binding from user-register
    @ModelAttribute("user")
    public User construtUser(){
        return new User();
    }
    
    @RequestMapping
    public String showRegister(){
        return "user-register";
    }
//    getting user after submit button
    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user-register";
        }
        userService.save(user);
        return "redirect:/register.html?succes=true";
    }
}
