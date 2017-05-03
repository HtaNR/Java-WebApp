/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;


import com.hatta.webapp.entity.Pemesanan;
import com.hatta.webapp.entity.User;
import com.hatta.webapp.repository.PemesananRepository;
import com.hatta.webapp.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hatta NR
 */
@Service
public class PemesananService {
  @Autowired
  private PemesananRepository pemesananRepository;
  @Autowired
  private UserRepository userRepository;

    public void save(Pemesanan pemesanan, String name) {
         User user =userRepository.findByName(name);
        int idUser = user.getId();
        pemesanan.setIdUser(idUser);
        pemesananRepository.save(pemesanan);
    }

    public void delete(int id) {
        pemesananRepository.delete(id);
    }
    
    public List<Pemesanan> findAll() {
        return pemesananRepository.findAll();
    }
  
  
}
