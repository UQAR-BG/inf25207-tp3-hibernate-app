package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Avion;
import com.inf25207.tp3.services.interfaces.IAvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/avion")
public class AvionController {
    private final IAvionService AvionService;

    @Autowired
    public AvionController(IAvionService AvionService) {
        this.AvionService = AvionService;
    }

    @GetMapping("/avions")
    public String viewAvions(Model model) {
        return "avions";
    }

    @GetMapping("/add")
    public String showNewAvionForm(Model model) {
        Avion Avion = new Avion();
        model.addAttribute("avion", Avion);
        return "new_avion";
    }

    @PostMapping("/save")
    public String saveAvion(@ModelAttribute("avion") Avion Avion) {
        AvionService.addAvion(Avion);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Avion Avion = AvionService.getAvion(id);
        model.addAttribute("avion", Avion);
        return "update_avion";
    }

    @GetMapping("/delete/{id}")
    public String deleteAvion(@PathVariable (value = "id") int id) {
        AvionService.deleteAvion(id);
        return "redirect:/";
    }
}
