package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.*;
import com.inf25207.tp3.services.interfaces.IModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/examination")
public class ExaminationController {
    private final IModelService<Examination> examinationService;
    private final IModelService<Pilote> piloteService;
    private final IModelService<Examen> examenService;
    private final IModelPropertyEditor<Pilote> piloteEditor;
    private final IModelPropertyEditor<Examen> examenEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Pilote.class, piloteEditor);
        binder.registerCustomEditor(Examen.class, examenEditor);
    }

    @Autowired
    public ExaminationController(
            IModelService<Examination> examinationService,
            IModelService<Pilote> piloteService,
            IModelService<Examen> examenService,
            IModelPropertyEditor<Pilote> piloteEditor,
            IModelPropertyEditor<Examen> examenEditor
    ) {
        this.examinationService = examinationService;
        this.piloteService = piloteService;
        this.examenService = examenService;
        this.piloteEditor = piloteEditor;
        this.examenEditor = examenEditor;
    }

    @GetMapping("/examinations")
    public String viewExaminations(Model model) {
        List<Examination> examinations = examinationService.getAll();
        model.addAttribute("examinations", examinations);
        return "examination/examinations";
    }

    @GetMapping("/examination/{id}")
    public String viewExamination(@PathVariable(value = "id") int id, Model model) {
        Examination examination = examinationService.getWithRelations(id);
        model.addAttribute("examination", examination);
        return "examination/examination";
    }

    @GetMapping("/add")
    public String showNewExaminationForm(Model model) {
        Examination examination = new Examination();
        model.addAttribute("examination", examination);

        Collection<Pilote> pilotes = piloteService.getAll();
        model.addAttribute("pilotes", pilotes);

        Collection<Examen> examens = examenService.getAll();
        model.addAttribute("examens", examens);

        return "examination/addExamination";
    }

    @PostMapping("/save")
    public String saveExamination(@Valid @ModelAttribute("examination") Examination examination, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            Collection<Pilote> pilotes = piloteService.getAll();
            model.addAttribute("pilotes", pilotes);

            Collection<Examen> examens = examenService.getAll();
            model.addAttribute("examens", examens);

            return "examination/addExamination";
        }
        examinationService.persist(examination);
        return "redirect:/examination/examination/" + examination.getIdExamination();
    }

    @GetMapping("/delete/{id}")
    public String deleteExamination(@PathVariable (value = "id") int id) {
        examinationService.delete(id);
        return "redirect:/examination/examinations";
    }
}
