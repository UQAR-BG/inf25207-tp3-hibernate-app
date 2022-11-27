package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Reparation;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reparation")
public class ReparationController {
    private final IModelService<Reparation> reparationService;

    @Autowired
    public ReparationController(IModelService<Reparation> reparationService) {
        this.reparationService = reparationService;
    }

    @GetMapping("/reparations")
    public String viewReparations(Model model) {
        return "reparations";
    }

    @GetMapping("/add")
    public String showNewReparationForm(Model model) {
        Reparation Reparation = new Reparation();
        model.addAttribute("reparation", Reparation);
        return "new_reparation";
    }

    @PostMapping("/save")
    public String saveReparation(@ModelAttribute("reparation") Reparation Reparation) {
        reparationService.persist(Reparation);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Reparation Reparation = reparationService.getWithRelations(id);
        model.addAttribute("reparation", Reparation);
        return "update_reparation";
    }

    @GetMapping("/delete/{id}")
    public String deleteReparation(@PathVariable (value = "id") int id) {
        reparationService.delete(id);
        return "redirect:/";
    }
}
