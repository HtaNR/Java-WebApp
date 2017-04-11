/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.repository;

import com.hatta.webapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Hatta NR
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
    
//    @Modifying(clearAutomatically = true)
//    @Query("Update User u SET u.name =:name, u.email =:email, u.password=:password WHERE u.id=:id ")
//    void updateUser(@Param("id") int id, @Param("name")String name, @Param("email")String email,@Param("password") String password);
}
