package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Examen;
import com.inf25207.tp3.services.interfaces.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/examen")
public class ExamenController {
    private final IExamenService ExamenService;

    @Autowired
    public ExamenController(IExamenService ExamenService) {
        this.ExamenService = ExamenService;
    }

    @GetMapping("/examens")
    public String viewExamens(Model model) {
        return "examens";
    }

    @GetMapping("/add")
    public String showNewExamenForm(Model model) {
        Examen Examen = new Examen();
        model.addAttribute("examen", Examen);
        return "new_examen";
    }

    @PostMapping("/save")
    public String saveExamen(@ModelAttribute("examen") Examen Examen) {
        ExamenService.addExamen(Examen);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Examen Examen = ExamenService.getExamen(id);
        model.addAttribute("examen", Examen);
        return "update_examen";
    }

    @GetMapping("/delete/{id}")
    public String deleteExamen(@PathVariable (value = "id") int id) {
        ExamenService.deleteExamen(id);
        return "redirect:/";
    }
}
