package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Examination;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/examination")
public class ExaminationController {
    private final IModelService<Examination> examinationService;

    @Autowired
    public ExaminationController(IModelService<Examination> examinationService) {
        this.examinationService = examinationService;
    }

    @GetMapping("/examinations")
    public String viewExaminations(Model model) {
        return "examinations";
    }

    @GetMapping("/add")
    public String showNewExaminationForm(Model model) {
        Examination examination = new Examination();
        model.addAttribute("examination", examination);
        return "new_examination";
    }

    @PostMapping("/save")
    public String saveExamination(@ModelAttribute("examination") Examination examination) {
        examinationService.persist(examination);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Examination examination = examinationService.getWithRelations(id);
        model.addAttribute("examination", examination);
        return "update_examination";
    }

    @GetMapping("/delete/{id}")
    public String deleteExamination(@PathVariable (value = "id") int id) {
        examinationService.delete(id);
        return "redirect:/";
    }
}
