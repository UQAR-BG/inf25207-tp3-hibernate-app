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
@RequestMapping("/reparation")
public class ReparationController {
    private final IModelService<Reparation> reparationService;
    private final IModelService<Avion> avionService;
    private final IModelService<Technicien> technicienService;
    private final IModelPropertyEditor<Avion> avionEditor;
    private final IModelPropertyEditor<Technicien> technicienEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Avion.class, avionEditor);
        binder.registerCustomEditor(Technicien.class, technicienEditor);
    }

    @Autowired
    public ReparationController(
            IModelService<Reparation> reparationService,
            IModelService<Avion> avionService,
            IModelService<Technicien> technicienService,
            IModelPropertyEditor<Avion> avionEditor,
            IModelPropertyEditor<Technicien> technicienEditor
    ) {
        this.reparationService = reparationService;
        this.avionService = avionService;
        this.technicienService = technicienService;
        this.avionEditor = avionEditor;
        this.technicienEditor = technicienEditor;
    }

    @GetMapping("/reparations")
    public String viewReparations(Model model) {
        List<Reparation> reparations = reparationService.getAll();
        model.addAttribute("reparations", reparations);
        return "reparation/reparations";
    }

    @GetMapping("/reparation/{id}")
    public String viewReparation(@PathVariable(value = "id") int id, Model model) {
        Reparation reparation = reparationService.getWithRelations(id);
        model.addAttribute("reparation", reparation);
        return "reparation/reparation";
    }

    @GetMapping("/add")
    public String showNewReparationForm(Model model) {
        Reparation reparation = new Reparation();
        model.addAttribute("reparation", reparation);

        Collection<Avion> avions = avionService.getAll();
        model.addAttribute("avions", avions);

        Collection<Technicien> techniciens = technicienService.getAll();
        model.addAttribute("techniciens", techniciens);

        return "reparation/addReparation";
    }

    @PostMapping("/save")
    public String saveReparation(@Valid @ModelAttribute("reparation") Reparation reparation, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            Collection<Avion> avions = avionService.getAll();
            model.addAttribute("avions", avions);

            Collection<Technicien> techniciens = technicienService.getAll();
            model.addAttribute("techniciens", techniciens);

            return "reparation/addReparation";
        }
        reparationService.persist(reparation);
        return "redirect:/reparation/reparation/" + reparation.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteReparation(@PathVariable (value = "id") int id) {
        reparationService.delete(id);
        return "redirect:/reparation/reparations";
    }
}
