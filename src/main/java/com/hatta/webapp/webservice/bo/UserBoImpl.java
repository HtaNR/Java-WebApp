/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.webservice.bo;

import com.hatta.webapp.entity.User;
import com.hatta.webapp.webservice.dao.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hatta NR
 */
public class UserBoImpl implements UserBo{
    
//    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    
    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
    
}
