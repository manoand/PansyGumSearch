package com.MnP.demo.web.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.MnP.demo.web.model.Bonbon;
import com.MnP.demo.web.service.BonbonService;

@Controller
public class CreateController extends SharedMeth {

    @Autowired
    private BonbonService bonbonservice;

    @PostMapping("/save")
    public ModelAndView creation(@Valid @ModelAttribute("bonbon") final Bonbon bonbon, final BindingResult result) {
        ModelAndView model = initCreate();
        if (result.hasErrors() || bonbon == null) {
            model.addObject("error", "Le format du poids doit correspondre à 1.2 par exemple.");
        } else {
            model = new ModelAndView(new RedirectView("/listObject"));
            bonbon.setId(new Date().toString().replaceAll(" ", ""));
            bonbonservice.save(bonbon);
        }
        return model;
    }

    @GetMapping("/create")
    public ModelAndView pageCreation() {
        final ModelAndView model = initCreate();
        model.addObject("bonbon", new Bonbon());
        return model;
    }
}
