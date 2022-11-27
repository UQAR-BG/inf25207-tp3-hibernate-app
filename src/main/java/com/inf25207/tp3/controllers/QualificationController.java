package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Qualification;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/qualification")
public class QualificationController {
    private final IModelService<Qualification> qualificationService;

    @Autowired
    public QualificationController(IModelService<Qualification> qualificationService) {
        this.qualificationService = qualificationService;
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
        qualificationService.persist(Qualification);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Qualification Qualification = qualificationService.getWithRelations(id);
        model.addAttribute("qualification", Qualification);
        return "update_qualification";
    }

    @GetMapping("/delete/{id}")
    public String deleteQualification(@PathVariable (value = "id") int id) {
        qualificationService.delete(id);
        return "redirect:/";
    }
}
