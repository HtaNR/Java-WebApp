/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.controller;

import com.hatta.webapp.entity.Jadwal;
import com.hatta.webapp.entity.KotaAsal;
import com.hatta.webapp.entity.KotaTujuan;
import com.hatta.webapp.service.JadwalService;
import com.hatta.webapp.service.KotaAsalService;
import com.hatta.webapp.service.KotaTujuanService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hatta NR
 */
@Controller
@RequestMapping("/jadwal")
public class JadwalContoller {

    @Autowired
    private KotaAsalService kotaAsalService;
    @Autowired
    private KotaTujuanService kotaTujuanService;
    @Autowired
    private JadwalService jadwalService;
    
    @ModelAttribute("Jadwals")
    public Jadwal constructJadwal(){
        return new Jadwal();
    }
    
    @ModelAttribute("kotaTujuan")
    public KotaTujuan construtKotaTujuan() {
        return new KotaTujuan();
    }

    @ModelAttribute("kotaAsal")
    public KotaAsal construtKotaAsal() {
        return new KotaAsal();
    }
    //////////////////////////////////////////////////////////////////////////////
    
     @RequestMapping()
    public String Jadwal(Model model) {
        model.addAttribute("tujuankota", kotaTujuanService.findAll());
        model.addAttribute("asalkota", kotaAsalService.findAll());
        model.addAttribute("schedules", jadwalService.findAll());
        return "jadwal";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String doRegisterJ(@Valid @ModelAttribute("Jadwals") Jadwal jadwal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "jadwal";
        }
        jadwalService.save(jadwal);       
        return "redirect:/jadwal.html";
    }
    
    @RequestMapping("/remove/{id}")
    public String removeJadwal(@PathVariable int id) {
        jadwalService.delete(id);
        return "redirect:/jadwal.html";
    }
    //////////////////////////////////////////////////////////////////////////////
    
    @RequestMapping(value = "/tujuan")
    public String KotaTujuan(Model model) {
        model.addAttribute("tujuankota", kotaTujuanService.findAll());
        return "jadwal/tujuan";
    }
    
    @RequestMapping(value = "/tujuan", method = RequestMethod.POST)
    public String doRegisterT(@Valid @ModelAttribute("kotaTujuan") KotaTujuan kotaTujuan, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "jadwal/tujuan";
        }
        kotaTujuanService.save(kotaTujuan);
        return "redirect:/jadwal/tujuan.html";
    }
    
    @RequestMapping("/tujuan/remove/{id}")
    public String removeTujuan(@PathVariable int id) {
//        KotaTujuan kotaTujuan = kotaTujuanService.findOne(id);
//        kotaTujuanService.delete(kotaTujuan);
        kotaTujuanService.delete(id);
        return "redirect:/jadwal/tujuan.html";
    }
    //////////////////////////////////////////////////////////////////////////////////////
    
    @RequestMapping(value = "/asal")
    public String KotaAsal(Model model) {
        model.addAttribute("asalkota", kotaAsalService.findAll());
        return "jadwal/asal";
    }
    
    @RequestMapping(value = "/asal", method = RequestMethod.POST)
    public String doRegisterA(@Valid @ModelAttribute("kotaAsal") KotaAsal kotaAsal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "jadwal/asal";
        }
        kotaAsalService.save(kotaAsal);
        return "redirect:/jadwal/asal.html";
    }
    
    @RequestMapping("asal/remove/{id}")
    public String removeAsal(@PathVariable int id) {
        kotaAsalService.delete(id);
        return "redirect:/jadwal/asal.html";
    }
}
