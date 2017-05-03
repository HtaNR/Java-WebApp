/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;

import com.hatta.webapp.entity.Jadwal;
import com.hatta.webapp.repository.JadwalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hatta NR
 */
@Service
public class JadwalService {
    @Autowired
    private JadwalRepository jadwalRepository;

    public List<Jadwal> findAll() {
        return jadwalRepository.findAll();
    }

    public void save(Jadwal jadwal) {
        jadwalRepository.save(jadwal);
    }

    public void delete(int id) {
        jadwalRepository.delete(id);
    }
    public Jadwal findById(int id) {
        return jadwalRepository.findOne(id);
    }
}   
