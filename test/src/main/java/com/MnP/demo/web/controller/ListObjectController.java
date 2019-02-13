package com.MnP.demo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MnP.demo.web.service.BonbonService;

@Controller
public class ListObjectController extends SharedMeth{

    @Autowired
    private BonbonService bonbonService;

    @GetMapping("/listObject")
    public ModelAndView mainPage() {
        return initListObj();
    }
    
    @PostMapping("/suppression")
    public ModelAndView deleteBonbon(HttpServletRequest request) {
    	bonbonService.delete(request.getParameter("idBonbon"));
    	ModelAndView model = initListObj();
    	return model;
    }

}
