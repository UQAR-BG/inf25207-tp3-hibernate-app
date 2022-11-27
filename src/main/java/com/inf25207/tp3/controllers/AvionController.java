package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Avion;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/avion")
public class AvionController {
    private final IModelService<Avion> avionService;

    @Autowired
    public AvionController(IModelService<Avion> avionService) {
        this.avionService = avionService;
    }

    @GetMapping("/avions")
    public String viewAvions(Model model) {
        return "avions";
    }

    @GetMapping("/add")
    public String showNewAvionForm(Model model) {
        Avion avion = new Avion();
        model.addAttribute("avion", avion);
        return "new_avion";
    }

    @PostMapping("/save")
    public String saveAvion(@ModelAttribute("avion") Avion avion) {
        avionService.persist(avion);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Avion avion = avionService.getWithRelations(id);
        model.addAttribute("avion", avion);
        return "update_avion";
    }

    @GetMapping("/delete/{id}")
    public String deleteAvion(@PathVariable (value = "id") int id) {
        avionService.delete(id);
        return "redirect:/";
    }
}
