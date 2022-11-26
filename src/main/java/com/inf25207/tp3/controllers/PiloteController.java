package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.services.interfaces.IPiloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pilote")
public class PiloteController {
    private final IPiloteService PiloteService;

    @Autowired
    public PiloteController(IPiloteService PiloteService) {
        this.PiloteService = PiloteService;
    }

    @GetMapping("/pilotes")
    public String viewPilotes(Model model) {
        return "pilotes";
    }

    @GetMapping("/add")
    public String showNewPiloteForm(Model model) {
        Pilote Pilote = new Pilote();
        model.addAttribute("pilote", Pilote);
        return "new_pilote";
    }

    @PostMapping("/save")
    public String savePilote(@ModelAttribute("pilote") Pilote Pilote) {
        PiloteService.addPilote(Pilote);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Pilote Pilote = PiloteService.getPilote(id);
        model.addAttribute("pilote", Pilote);
        return "update_pilote";
    }

    @GetMapping("/delete/{id}")
    public String deletePilote(@PathVariable (value = "id") int id) {
        PiloteService.deletePilote(id);
        return "redirect:/";
    }
}
