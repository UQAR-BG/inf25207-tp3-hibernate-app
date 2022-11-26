package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Technicien;
import com.inf25207.tp3.services.interfaces.ITechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/technicien")
public class TechnicienController {
    private final ITechnicienService TechnicienService;

    @Autowired
    public TechnicienController(ITechnicienService TechnicienService) {
        this.TechnicienService = TechnicienService;
    }

    @GetMapping("/techniciens")
    public String viewTechniciens(Model model) {
        return "techniciens";
    }

    @GetMapping("/add")
    public String showNewTechnicienForm(Model model) {
        Technicien Technicien = new Technicien();
        model.addAttribute("technicien", Technicien);
        return "new_technicien";
    }

    @PostMapping("/save")
    public String saveTechnicien(@ModelAttribute("technicien") Technicien Technicien) {
        TechnicienService.addTechnicien(Technicien);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Technicien Technicien = TechnicienService.getTechnicien(id);
        model.addAttribute("technicien", Technicien);
        return "update_technicien";
    }

    @GetMapping("/delete/{id}")
    public String deleteTechnicien(@PathVariable (value = "id") int id) {
        TechnicienService.deleteTechnicien(id);
        return "redirect:/";
    }
}
