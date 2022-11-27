package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Examen;
import com.inf25207.tp3.services.interfaces.IExamenService;
import com.inf25207.tp3.services.interfaces.IExaminationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/examen")
public class ExamenController {
    private final IExamenService examenService;
    private final IExaminationService examinationService;

    @Autowired
    public ExamenController(IExamenService examenService, IExaminationService examinationService) {
        this.examenService = examenService;
        this.examinationService = examinationService;
    }

    @GetMapping("/examens")
    public String viewExamens(Model model) {
        List<Examen> examens = examenService.getExamens();
        model.addAttribute("examens", examens);
        return "examen/examens";
    }

    @GetMapping("/examen/{id}")
    public String viewExamen(@PathVariable(value = "id") int id, Model model) {
        Examen examen = examenService.getExamen(id);
        model.addAttribute("examen", examen);
        model.addAttribute("pilotes", examen.getPilotes());
        return "examen/examen";
    }

    @GetMapping("/add")
    public String showNewExamenForm(Model model) {
        Examen examen = new Examen();
        model.addAttribute("examen", examen);
        return "examen/addExamen";
    }

    @PostMapping("/save")
    public String saveExamen(@Valid @ModelAttribute("examen") Examen examen, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "examen/addExamen";
        }
        examenService.addExamen(examen);
        return "redirect:/examen/examen/" + examen.getIdExamen();
    }

    @GetMapping("/delete/{id}")
    public String deleteExamen(@PathVariable (value = "id") int id) {
        examenService.deleteExamen(id);
        return "redirect:/examen/examens";
    }
}
