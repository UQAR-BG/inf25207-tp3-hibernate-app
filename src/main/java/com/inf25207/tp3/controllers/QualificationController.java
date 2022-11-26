package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Qualification;
import com.inf25207.tp3.services.interfaces.IQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/qualification")
public class QualificationController {
    private final IQualificationService QualificationService;

    @Autowired
    public QualificationController(IQualificationService QualificationService) {
        this.QualificationService = QualificationService;
    }

    @GetMapping("/qualifications")
    public String viewQualifications(Model model) {
        return "qualifications";
    }

    @GetMapping("/add")
    public String showNewQualificationForm(Model model) {
        Qualification Qualification = new Qualification();
        model.addAttribute("qualification", Qualification);
        return "new_qualification";
    }

    @PostMapping("/save")
    public String saveQualification(@ModelAttribute("qualification") Qualification Qualification) {
        QualificationService.addQualification(Qualification);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Qualification Qualification = QualificationService.getQualification(id);
        model.addAttribute("qualification", Qualification);
        return "update_qualification";
    }

    @GetMapping("/delete/{id}")
    public String deleteQualification(@PathVariable (value = "id") int id) {
        QualificationService.deleteQualification(id);
        return "redirect:/";
    }
}
