package com.MnP.demo.web.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MnP.demo.web.model.Bonbon;
import com.MnP.demo.web.service.BonbonService;

@Controller
public class ModifController extends SharedMeth {

    @Autowired
    BonbonService bonbonservice;

    @PostMapping("/update")
    public ModelAndView modification(@Valid @ModelAttribute("bonbon") final Bonbon bonbon, final BindingResult result) {
        ModelAndView model = initCreate();
        if (result.hasErrors() || bonbon == null) {
            model.addObject("error", "Le format du poids doit correspondre à 1.2 par exemple.");
        } else {
            bonbonservice.update(bonbon);
            model = initListObj();
        }
        return model;
    }

    @PostMapping("/modifification")
    public ModelAndView pageModification(HttpServletRequest request) {
    	String id = request.getParameter("idBonbon");
    	final ModelAndView model = new ModelAndView();
        model.setViewName("create");
        model.addObject("titre", "Modification");
        model.addObject("nomEcran", "Modification");
        model.addObject("bouton", "Modifier");
        model.addObject("action", "update");
        final Pattern pattern = Pattern.compile("[0-9]*\\.*[0-9]*");
        final Matcher match = pattern.matcher(id);
        if (match.find()) {
            model.addObject("bonbon", bonbonservice.findById(id));
        }
        return model;
    }
}
