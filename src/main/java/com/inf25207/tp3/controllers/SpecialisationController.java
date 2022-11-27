package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/specialisation")
public class SpecialisationController {
    private final IModelService<Specialisation> specialisationService;

    @Autowired
    public SpecialisationController(IModelService<Specialisation> specialisationService) {
        this.specialisationService = specialisationService;
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
        specialisationService.persist(Specialisation);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Specialisation Specialisation = specialisationService.getWithRelations(id);
        model.addAttribute("specialisation", Specialisation);
        return "update_specialisation";
    }

    @GetMapping("/delete/{id}")
    public String deleteSpecialisation(@PathVariable (value = "id") int id) {
        specialisationService.delete(id);
        return "redirect:/";
    }
}
