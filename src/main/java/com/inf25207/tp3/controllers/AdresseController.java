package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.services.interfaces.IAdresseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<Adresse> adresses = adresseService.getAdresses();
        model.addAttribute("adresses", adresses);
        return "adresse/adresses";
    }

    @GetMapping("/adresse/{id}")
    public String viewAdresse(@PathVariable(value = "id") int id, Model model) {
        Adresse adresse = adresseService.getAdresse(id);
        model.addAttribute("adresse", adresse);
        return "adresse/adresse";
    }
 
    @GetMapping("/add")
    public String showNewAdresseForm(Model model) {
        Adresse adresse = new Adresse();
        model.addAttribute("adresse", adresse);
        return "adresse/addAdresse";
    }
 
    @PostMapping("/save")
    public String saveAdresse(@Valid @ModelAttribute("adresse") Adresse adresse, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "adresse/addAdresse";
        }
        adresseService.addAdresse(adresse);
        return "redirect:/adresse/adresse/" + adresse.getId();
    }
 
    @GetMapping("/delete/{id}")
    public String deleteAdresse(@PathVariable(value = "id") int id) {
        adresseService.deleteAdresse(id);
        return "redirect:/adresse/adresses";
    }
}
