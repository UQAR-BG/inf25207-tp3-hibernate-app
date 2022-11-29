package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.domain.models.Pilote;
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
@RequestMapping("/pilote")
public class PiloteController {
    private final IModelService<Pilote> piloteService;
    private final IModelService<Employe> employeService;
    private final IModelPropertyEditor<Employe> employeEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Employe.class, employeEditor);
    }

    @Autowired
    public PiloteController(
            IModelService<Pilote> piloteService,
            IModelService<Employe> employeService,
            IModelPropertyEditor<Employe> employeEditor
    ) {
        this.piloteService = piloteService;
        this.employeService = employeService;
        this.employeEditor = employeEditor;
    }

    @GetMapping("/pilotes")
    public String viewPilotes(Model model) {
        List<Pilote> pilotes = piloteService.getAll();
        model.addAttribute("pilotes", pilotes);
        return "pilote/pilotes";
    }

    @GetMapping("/pilote/{id}")
    public String viewPilote(@PathVariable(value = "id") int id, Model model) {
        Pilote pilote = piloteService.getWithRelations(id);
        model.addAttribute("pilote", pilote);
        model.addAttribute("examinations", pilote.getExaminations());
        model.addAttribute("qualifications", pilote.getQualifications());
        model.addAttribute("listePiloter", pilote.getExperiences());
        return "pilote/pilote";
    }

    @GetMapping("/add")
    public String showNewPiloteForm(Model model) {
        Pilote pilote = new Pilote();
        model.addAttribute("pilote", pilote);

        Collection<Employe> employes = employeService.getAll();
        model.addAttribute("employes", employes);

        return "pilote/addPilote";
    }

    @PostMapping("/save")
    public String savePilote(@Valid @ModelAttribute("pilote") Pilote pilote, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "pilote/addPilote";
        }
        piloteService.persist(pilote);
        return "redirect:/pilote/pilote/" + pilote.getMatricule();
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Pilote pilote = piloteService.getWithRelations(id);
        model.addAttribute("pilote", pilote);
        model.addAttribute("examinations", pilote.getExaminations());
        model.addAttribute("qualifications", pilote.getQualifications());
        model.addAttribute("listePiloter", pilote.getExperiences());
        model.addAttribute("isUpdating", true);

        Collection<Employe> employes = employeService.getAll();
        model.addAttribute("employes", employes);

        return "pilote/pilote";
    }

    @PostMapping("/save/{id}")
    public String updatePilote(@PathVariable( value = "id") int id, @Valid @ModelAttribute("pilote") Pilote pilote, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("isUpdating", true);
            return "pilote/pilote";
        }

        pilote.setMatricule(id);
        pilote = piloteService.update(pilote);

        model.addAttribute("isUpdating", false);
        return "redirect:/pilote/pilote/" + pilote.getMatricule();
    }

    @GetMapping("/delete/{id}")
    public String deletePilote(@PathVariable (value = "id") int id) {
        piloteService.delete(id);
        return "redirect:/pilote/pilotes";
    }
}
