package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.services.interfaces.ISpecialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/specialisation")
public class SpecialisationController {
    private final ISpecialisationService SpecialisationService;

    @Autowired
    public SpecialisationController(ISpecialisationService SpecialisationService) {
        this.SpecialisationService = SpecialisationService;
    }

    @GetMapping("/specialisations")
    public String viewSpecialisations(Model model) {
        return "specialisations";
    }

    @GetMapping("/add")
    public String showNewSpecialisationForm(Model model) {
        Specialisation Specialisation = new Specialisation();
        model.addAttribute("specialisation", Specialisation);
        return "new_specialisation";
    }

    @PostMapping("/save")
    public String saveSpecialisation(@ModelAttribute("specialisation") Specialisation Specialisation) {
        SpecialisationService.addSpecialisation(Specialisation);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Specialisation Specialisation = SpecialisationService.getSpecialisation(id);
        model.addAttribute("specialisation", Specialisation);
        return "update_specialisation";
    }

    @GetMapping("/delete/{id}")
    public String deleteSpecialisation(@PathVariable (value = "id") int id) {
        SpecialisationService.deleteSpecialisation(id);
        return "redirect:/";
    }
}
