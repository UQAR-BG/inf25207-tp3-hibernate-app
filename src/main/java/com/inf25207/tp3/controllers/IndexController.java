package com.inf25207.tp3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Bastien Goulet
 * */

@Controller
public class IndexController {
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "HowToDoInJava Reader !!");
        return "index";
    }
}