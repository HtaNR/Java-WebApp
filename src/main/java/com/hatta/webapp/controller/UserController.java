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
import javax.validation.Valid;
import org.omg.CosNaming.BindingIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
             
     @ModelAttribute("blog")
    public Blog construtBlog(){
        return new Blog();
    }
    
   
//   getting user data specificaly
    @RequestMapping("/account")
    public String account(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("user", userService.findOneWithBlogs(name));
        return"account";
    }
    //validation server side
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult bindingResult,Principal principal){
        if(bindingResult.hasErrors()){
            return account(model,principal);
        }
        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account.html";
    }
    
    @RequestMapping("/blog/remove/{id}")
    public String removeBlog(@PathVariable int id){
        Blog blog = blogService.findOne(id);
        blogService.delete(blog);
        return "redirect:/account.html";
    }
    
   
}
