/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.controller;

import com.hatta.webapp.entity.Jadwal;
import com.hatta.webapp.entity.Pemesanan;
import com.hatta.webapp.service.JadwalService;
import com.hatta.webapp.service.PemesananService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hatta NR
 */
@Controller
@RequestMapping("/pemesanan")

public class PemesananController {

    @Autowired
    private PemesananService pemesananService;
    @Autowired
    private JadwalService jadwalService;
    @Autowired
    private MessageSource messageSource;

    @ModelAttribute("Pemesanan")
    public Pemesanan constructPemesanan() {
        return new Pemesanan();
    }

    //////////////////////////////////////////////////////////////////////////////
    @RequestMapping()
    public String Pemesanan(Model model) {
        model.addAttribute("schedules", jadwalService.findAll());
        model.addAttribute("listPemesanan", pemesananService.findAll());
        return "pemesanan";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegisterP(@Valid @ModelAttribute("Pemesanan") Pemesanan pemesanan, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            for (Object object : bindingResult.getAllErrors()) {
                if (object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;

                    String message = messageSource.getMessage(fieldError, null);
                    System.out.println(message);
                }
            }
            return "pemesanan";
        }
//        String tes = pemesanan.getJadwal().toString();
//        Jadwal jadwalsave = jadwalService.findById(tes);
        String name = principal.getName();
        pemesananService.save(pemesanan, name);
        return "redirect:/pemesanan.html";
    }

    @RequestMapping("/remove/{id}")
    public String removePemesanan(@PathVariable int id) {
        pemesananService.delete(id);
        return "redirect:/pemesanan.html";
    }
    //////////////////////////////////////////////////////////////////////////////

}
