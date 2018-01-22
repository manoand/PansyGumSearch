package com.MnP.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListObjectController {

    @GetMapping("/listObject")
    public ModelAndView mainPage() {

        final ModelAndView model = new ModelAndView();
        model.setViewName("listObject");
        model.addObject("nom", "Test");
        return model;
    }
}
