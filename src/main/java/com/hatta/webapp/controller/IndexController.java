/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.controller;

import com.hatta.webapp.entity.User;
import com.hatta.webapp.service.ItemService;
import com.hatta.webapp.webservice.bo.UserBo;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
//    @Autowired
//    private UserBo userBo;
//    
//    private static final Logger logger = Logger.getLogger(com.hatta.webapp.webservice.controller.UserController.class);
//    
//    @RequestMapping(value = "/listusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<User>> findAllUser(){
//        List<User> users = userBo.findAllUser();
//        if (users.isEmpty())
//                return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
//        return new ResponseEntity<List<User>>(users, new HttpHeaders(),HttpStatus.OK);
//    }
//    
}
