package com.MnP.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateController {

	@GetMapping("/create")
	public ModelAndView pageCreation() {
        final ModelAndView model = new ModelAndView();
        model.setViewName("create");
        return model;
	}
}
