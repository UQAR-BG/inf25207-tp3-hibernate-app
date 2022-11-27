package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pilote")
public class PiloteController {
    private final IModelService<Pilote> piloteService;

    @Autowired
    public PiloteController(IModelService<Pilote> piloteService) {
        this.piloteService = piloteService;
    }

    @GetMapping("/pilotes")
    public String viewPilotes(Model model) {
        return "pilotes";
    }

    @GetMapping("/add")
    public String showNewPiloteForm(Model model) {
        Pilote pilote = new Pilote();
        model.addAttribute("pilote", pilote);
        return "new_pilote";
    }

    @PostMapping("/save")
    public String savePilote(@ModelAttribute("pilote") Pilote pilote) {
        piloteService.persist(pilote);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Pilote pilote = piloteService.getWithRelations(id);
        model.addAttribute("pilote", pilote);
        return "update_pilote";
    }

    @GetMapping("/delete/{id}")
    public String deletePilote(@PathVariable (value = "id") int id) {
        piloteService.delete(id);
        return "redirect:/";
    }
}
