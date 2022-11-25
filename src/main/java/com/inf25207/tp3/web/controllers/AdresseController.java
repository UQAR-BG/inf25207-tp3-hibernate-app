package com.inf25207.tp3.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adresse")
public class AdresseController {

    @RequestMapping(value="/adresses", method = RequestMethod.GET)
    public String getAdresses() {
        return "adresses";
    }
}
