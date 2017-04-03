/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.webservice.dao;

import com.hatta.webapp.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hatta NR
 */
public class UserDaoImpl implements UserDao {
//    
//    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional
    @Override
    public List<User> findAllUser() {
        List<User> users = new ArrayList<User>();
        users = this.sessionFactory.getCurrentSession().createQuery("from app_user").list();
        return users;
        
    }
    
}
