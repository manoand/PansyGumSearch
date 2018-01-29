package com.MnP.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
        model.addObject("listBonbon", bonbonService.findAll());
        return model;
    }

}
