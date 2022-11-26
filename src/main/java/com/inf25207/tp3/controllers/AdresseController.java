package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.services.interfaces.IAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adresse")
public class AdresseController {
    private final IAdresseService adresseService;

    @Autowired
    public AdresseController(IAdresseService adresseService) {
        this.adresseService = adresseService;
    }
 
    @GetMapping("/adresses")
    public String viewAdresses(Model model) {
        return "adresses";
    }
 
    @GetMapping("/add")
    public String showNewAdresseForm(Model model) {
        Adresse adresse = new Adresse();
        model.addAttribute("adresse", adresse);
        return "new_adresse";
    }
 
    @PostMapping("/save")
    public String saveAdresse(@ModelAttribute("adresse") Adresse adresse) {
        adresseService.addAdresse(adresse);
        return "redirect:/";
    }
 
    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Adresse adresse = adresseService.getAdresse(id);
        model.addAttribute("adresse", adresse);
        return "update_adresse";
    }
 
    @GetMapping("/delete/{id}")
    public String deleteAdresse(@PathVariable (value = "id") int id) {
        adresseService.deleteAdresse(id);
        return "redirect:/";
    }
}
