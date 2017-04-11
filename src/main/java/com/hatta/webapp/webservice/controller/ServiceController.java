/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.webservice.controller;

import com.hatta.webapp.entity.User;
import com.hatta.webapp.webservice.bo.UserBo;
import com.hatta.webapp.webservice.dao.UserDao;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Hatta NR
 */
@RestController
public class ServiceController {

    @Autowired
    private UserBo userBo;

    private static final Logger logger = Logger.getLogger(ServiceController.class);

    @Transactional
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<User>> findAllUser() {
        List<User> users = userBo.findAllUser();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<User> getCustomer(@PathVariable("id") int id) {
        logger.info("###### Fetching Customer with id " + id + " ######");
        User user = userBo.findUserById(id);

        if (user == null) {
            logger.info("###### Customer with id " + id + " not found" + " ######");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }
    @Transactional
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Void> createCustomer(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        logger.info("###### Creating Customer " + user.getName() + " ######");
        User newUser = new User(user.getId(), user.getName(),user.getEmail(),user.getPassword());

        try {
            userBo.insert(newUser);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());

            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }
     @Transactional
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<User> updateCustomer(@RequestBody User user) {
		logger.info("###### Updating Customer " + user.getId() +  " ######"); 
        User updateUser = userBo.findUserById(user.getId());
         
        if (updateUser==null) {
        	logger.info("###### Customer with id " + user.getId() + " not found" +  " ######");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
       
        userBo.update(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @Transactional
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteCustomer(@PathVariable("id") int id) {
		logger.info("###### Fetching & Deleting Customer with id " + id +  " ######");
        User customer = userBo.findUserById(id);
        if (customer == null) {
        	logger.info("###### Unable to delete. Customer with id " + id + " not found" +  " ######");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userBo.delete(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllCustomers() {
		logger.info("###### Deleting all Customers ######"); 
        userBo.deleteAll();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    
    
}
