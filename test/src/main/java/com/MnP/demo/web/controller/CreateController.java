package com.MnP.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.MnP.demo.web.model.Bonbon;
import com.MnP.demo.web.service.BonbonService;

@Controller
public class CreateController {

    @Autowired
    BonbonService bonbonservice;

    @PostMapping("/save")
    public ModelAndView creation(@ModelAttribute("bonbon") final Bonbon bonbon) {
        bonbonservice.save(bonbon);
        return new ModelAndView(new RedirectView("/listObject"));
    }

    @GetMapping("/create")
    public ModelAndView pageCreation() {
        final ModelAndView model = new ModelAndView();
        model.setViewName("create");
        model.addObject("titre", "Créer votre bonbon !");
        model.addObject("nomEcran", "Création");
        model.addObject("action", "Créer");
        model.addObject("bonbon", new Bonbon());
        return model;
    }
}
