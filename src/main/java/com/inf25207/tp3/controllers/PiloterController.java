package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Piloter;
import com.inf25207.tp3.services.interfaces.IPiloterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/piloter")
public class PiloterController {
    private final IPiloterService PiloterService;

    @Autowired
    public PiloterController(IPiloterService PiloterService) {
        this.PiloterService = PiloterService;
    }

    @GetMapping("/liste_piloter")
    public String viewPiloters(Model model) {
        return "liste_piloter";
    }

    @GetMapping("/add")
    public String showNewPiloterForm(Model model) {
        Piloter Piloter = new Piloter();
        model.addAttribute("piloter", Piloter);
        return "new_piloter";
    }

    @PostMapping("/save")
    public String savePiloter(@ModelAttribute("piloter") Piloter Piloter) {
        PiloterService.addPiloter(Piloter);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Piloter Piloter = PiloterService.getPiloter(id);
        model.addAttribute("piloter", Piloter);
        return "update_piloter";
    }

    @GetMapping("/delete/{id}")
    public String deletePiloter(@PathVariable (value = "id") int id) {
        PiloterService.deletePiloter(id);
        return "redirect:/";
    }
}
