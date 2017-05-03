/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;

import com.hatta.webapp.entity.KotaTujuan;
import com.hatta.webapp.repository.KotaTujuanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hatta NR
 */
@Service
public class KotaTujuanService {
    @Autowired
    private KotaTujuanRepository kotaTujuanRepository;

    public void save(KotaTujuan kota) {
        kotaTujuanRepository.save(kota);
    }

    public void delete(int id) {
        kotaTujuanRepository.delete(id);
    }
    public void delete(KotaTujuan kotaTujuan){
        kotaTujuanRepository.delete(kotaTujuan);
    }

    public List<KotaTujuan> findAll() {
        return kotaTujuanRepository.findAll();
    }
    public KotaTujuan findOne(int id){
        return kotaTujuanRepository.findOne(id);
    }
}
