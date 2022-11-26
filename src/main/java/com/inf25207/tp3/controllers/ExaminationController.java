package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Examination;
import com.inf25207.tp3.services.interfaces.IExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/examination")
public class ExaminationController {
    private final IExaminationService ExaminationService;

    @Autowired
    public ExaminationController(IExaminationService ExaminationService) {
        this.ExaminationService = ExaminationService;
    }

    @GetMapping("/examinations")
    public String viewExaminations(Model model) {
        return "examinations";
    }

    @GetMapping("/add")
    public String showNewExaminationForm(Model model) {
        Examination Examination = new Examination();
        model.addAttribute("examination", Examination);
        return "new_examination";
    }

    @PostMapping("/save")
    public String saveExamination(@ModelAttribute("examination") Examination Examination) {
        ExaminationService.addExamination(Examination);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Examination Examination = ExaminationService.getExamination(id);
        model.addAttribute("examination", Examination);
        return "update_examination";
    }

    @GetMapping("/delete/{id}")
    public String deleteExamination(@PathVariable (value = "id") int id) {
        ExaminationService.deleteExamination(id);
        return "redirect:/";
    }
}
