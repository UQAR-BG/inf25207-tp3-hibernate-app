package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.domain.models.Qualification;
import com.inf25207.tp3.domain.models.Type;
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
@RequestMapping("/qualification")
public class QualificationController {
    private final IModelService<Qualification> qualificationService;
    private final IModelService<Type> typeService;
    private final IModelService<Pilote> piloteService;
    private final IModelPropertyEditor<Type> typeEditor;
    private final IModelPropertyEditor<Pilote> piloteEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Type.class, typeEditor);
        binder.registerCustomEditor(Pilote.class, piloteEditor);
    }

    @Autowired
    public QualificationController(
            IModelService<Qualification> qualificationService,
            IModelService<Type> typeService,
            IModelService<Pilote> piloteService,
            IModelPropertyEditor<Type> typeEditor,
            IModelPropertyEditor<Pilote> piloteEditor
    ) {
        this.qualificationService = qualificationService;
        this.typeService = typeService;
        this.piloteService = piloteService;
        this.typeEditor = typeEditor;
        this.piloteEditor = piloteEditor;
    }

    @GetMapping("/qualifications")
    public String viewQualifications(Model model) {
        List<Qualification> qualifications = qualificationService.getAll();
        model.addAttribute("qualifications", qualifications);
        return "qualification/qualifications";
    }

    @GetMapping("/qualification/{id}")
    public String viewQualification(@PathVariable(value = "id") int id, Model model) {
        Qualification qualification = qualificationService.getWithRelations(id);
        model.addAttribute("qualification", qualification);
        return "qualification/qualification";
    }

    @GetMapping("/add")
    public String showNewQualificationForm(Model model) {
        Qualification qualification = new Qualification();
        model.addAttribute("qualification", qualification);

        Collection<Type> types = typeService.getAll();
        model.addAttribute("types", types);

        Collection<Pilote> pilotes = piloteService.getAll();
        model.addAttribute("pilotes", pilotes);

        return "qualification/addQualification";
    }

    @PostMapping("/save")
    public String saveQualification(@Valid @ModelAttribute("qualification") Qualification qualification, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            Collection<Type> types = typeService.getAll();
            model.addAttribute("types", types);

            Collection<Pilote> pilotes = piloteService.getAll();
            model.addAttribute("pilotes", pilotes);

            return "qualification/addQualification";
        }

        qualificationService.persist(qualification);
        return "redirect:/qualification/qualification/" + qualification.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteQualification(@PathVariable (value = "id") int id) {
        qualificationService.delete(id);
        return "redirect:/qualification/qualifications";
    }
}
