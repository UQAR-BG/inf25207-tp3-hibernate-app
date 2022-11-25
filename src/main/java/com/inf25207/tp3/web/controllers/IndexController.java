package com.inf25207.tp3.web.controllers;

import com.inf25207.tp3.services.interfaces.IAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    private IAdresseService adresseService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("adresses", adresseService.getAdresses());
        model.addAttribute("message", "HowToDoInJava Reader !!");
        return "index";
    }
}