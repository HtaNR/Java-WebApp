/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.webservice.bo.Impl;

import com.hatta.webapp.entity.User;
import com.hatta.webapp.webservice.bo.UserBo;
import com.hatta.webapp.webservice.dao.UserDao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hatta NR
 */
public class UserBoImpl implements UserBo{
    
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
   @Transactional  
    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int userId) {
        userDao.delete(userId);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }
}
