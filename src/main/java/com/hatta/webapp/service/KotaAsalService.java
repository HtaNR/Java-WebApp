/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;

import com.hatta.webapp.entity.KotaAsal;
import com.hatta.webapp.repository.KotaAsalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hatta NR
 */
@Service
public class KotaAsalService {
    @Autowired
    private KotaAsalRepository kotaAsalRepository;

    public List<KotaAsal> findAll() {
        return kotaAsalRepository.findAll();
    }

    public void save(KotaAsal kotaAsal) {
        kotaAsalRepository.save(kotaAsal);
    }

    public void delete(int id) {
        kotaAsalRepository.delete(id);
    }
}
