/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.webservice.dao.Impl;

import com.hatta.webapp.entity.Role;
import com.hatta.webapp.entity.User;
import com.hatta.webapp.repository.RoleRepository;
import com.hatta.webapp.repository.UserRepository;
import com.hatta.webapp.webservice.dao.UserDao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Hatta NR
 */
//@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    

    @Override
    public List<User> findAllUser() {
        Query query = getEntityManager().createQuery("select c from User c");
        List<User> users = query.getResultList();
        return users;
        
    }
    
 
    @Override
    public User findUserById(int id) {
        Query query = getEntityManager().createQuery("select c from User c where c.id=:id").setParameter("id", id);
        List<User> users = query.getResultList(); 
        return (User)users.get(0);
    }

    @Override
    public void insert(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnabled(true);
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);     
        userRepository.save(user);
    }
  
    @Override
    public void update(User user) {
        User old = findUserById(user.getId());
        String oldPass = old.getPassword();
        System.out.println("password-------"+oldPass);
        String newPass = user.getPassword();
        System.out.println("password-------"+newPass);
        
        if(!oldPass.equals(newPass)){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(newPass));
        }
        
        user.setEnabled(true);
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles); 
        userRepository.save(user);
    }

    @Override
    public void delete(int userId) {
        userRepository.delete(userId);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
    
    
}
