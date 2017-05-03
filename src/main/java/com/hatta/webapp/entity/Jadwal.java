/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Hatta NR
 */
@Entity
public class Jadwal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @JoinColumn(name = "asal_id")
//    @OneToOne   
//    private KotaAsal kotaAsal;
//    @JoinColumn(name = "tujuan_id")
//    @OneToOne
//    private KotaTujuan kotaTujuan;
    
    private String kotaAsal;

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }
    private String kotaTujuan;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date tanggalBerangkat;
    private String jamBerangkat;
    private int harga;
    private int seat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
   

//    public KotaAsal getKotaAsal() {
//        return kotaAsal;
//    }
//
//    public void setKotaAsal(KotaAsal kotaAsal) {
//        this.kotaAsal = kotaAsal;
//    }
//
//    public KotaTujuan getKotaTujuan() {
//        return kotaTujuan;
//    }
//
//    public void setKotaTujuan(KotaTujuan kotaTujuan) {
//        this.kotaTujuan = kotaTujuan;
//    }

    public Date getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(Date tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public String getJamBerangkat() {
        return jamBerangkat;
    }

    public void setJamBerangkat(String jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

}
