/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.repository;

import com.hatta.webapp.entity.Pemesanan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Hatta NR
 */
public interface PemesananRepository extends JpaRepository<Pemesanan, Integer>{
    
}
