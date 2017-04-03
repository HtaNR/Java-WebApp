/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.webservice.bo;

import com.hatta.webapp.entity.User;
import java.util.List;

/**
 *
 * @author Hatta NR
 */
public interface UserBo {
    public List<User> findAllUser();
}
