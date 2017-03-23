/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.repository;

import com.hatta.webapp.entity.Blog;
import com.hatta.webapp.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Hatta NR
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByUser(User user);
}
