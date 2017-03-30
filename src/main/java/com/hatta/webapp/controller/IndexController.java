/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.controller;

import com.hatta.webapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Hatta NR
 */
@Controller
public class IndexController {
    
    @Autowired
    private ItemService itemService;
    
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("items", itemService.getItems());
        return "index";
    }
    
    @RequestMapping("/chat")
    public String chat(){
        return "chat";
    }
    
}
