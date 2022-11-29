package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.services.interfaces.IModelService;
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
    private final IModelService<Adresse> adresseService;

    @Autowired
    public AdresseController(IModelService<Adresse> adresseService) {
        this.adresseService = adresseService;
    }
 
    @GetMapping("/adresses")
    public String viewAdresses(Model model) {
        List<Adresse> adresses = adresseService.getAll();
        model.addAttribute("adresses", adresses);
        return "adresse/adresses";
    }

    @GetMapping("/adresse/{id}")
    public String viewAdresse(@PathVariable(value = "id") int id, Model model) {
        Adresse adresse = adresseService.getWithRelations(id);
        model.addAttribute("adresse", adresse);
        model.addAttribute("isUpdating", false);
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
        adresseService.persist(adresse);
        return "redirect:/adresse/adresse/" + adresse.getId();
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Adresse adresse = adresseService.getWithRelations(id);
        model.addAttribute("adresse", adresse);
        model.addAttribute("isUpdating", true);
        return "adresse/adresse";
    }

    @PostMapping("/save/{id}")
    public String updateAdresse(@PathVariable( value = "id") int id, @Valid @ModelAttribute("adresse") Adresse adresse, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("isUpdating", true);
            return "adresse/adresse";
        }
        adresse = adresseService.update(adresse);
        model.addAttribute("isUpdating", false);
        return "redirect:/adresse/adresse/" + adresse.getId();
    }
 
    @GetMapping("/delete/{id}")
    public String deleteAdresse(@PathVariable(value = "id") int id) {
        adresseService.delete(id);
        return "redirect:/adresse/adresses";
    }
}
