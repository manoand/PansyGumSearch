package com.MnP.demo.web.controller;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MnP.demo.web.model.Bonbon;
import com.MnP.demo.web.service.BonbonService;

@Controller
public class ListObjectController {

    @Autowired
    BonbonService bonbonService;

    @GetMapping("/listObject")
    public ModelAndView mainPage() {
        final ModelAndView model = new ModelAndView();
        model.setViewName("listObject");
        model.addObject("nomEcran", "Accueil");
        model.addObject("listBonbon", IteratorUtils.toList(bonbonService.findAll().iterator()));
        return model;
    }
    
//	bonbonService.save(new Bonbon(Long.valueOf("1"), "Tête brulée", "rouge", Double.valueOf("1.2"), "sucre,vanille,amande"));
//    bonbonService.save(new Bonbon(
//        Long.valueOf("2"),
//        "Cocoa",
//        "noir,rouge,transparent",
//        Double.valueOf("1.2"),
//        "sucre,vanille,amande"));
//    bonbonService.save(new Bonbon(Long.valueOf("3"), "Oeuf", "blanc,jaune", Double.valueOf("1.2"), "sucre,vanille,amande"));

}
