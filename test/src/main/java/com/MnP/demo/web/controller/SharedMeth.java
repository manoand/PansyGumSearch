package com.MnP.demo.web.controller;

import org.springframework.web.servlet.ModelAndView;

public class SharedMeth {

    public ModelAndView initCreate() {
        final ModelAndView model = new ModelAndView();
        model.setViewName("create");
        model.addObject("titre", "Créer votre bonbon !");
        model.addObject("nomEcran", "Création");
        model.addObject("bouton", "Créer");
        model.addObject("action", "save");
        return model;
    }
}
