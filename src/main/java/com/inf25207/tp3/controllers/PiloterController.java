package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.Avion;
import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.domain.models.Piloter;
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
@RequestMapping("/piloter")
public class PiloterController {
    private final IModelService<Piloter> piloterService;
    private final IModelService<Avion> avionService;
    private final IModelService<Pilote> piloteService;
    private final IModelPropertyEditor<Avion> avionEditor;
    private final IModelPropertyEditor<Pilote> piloteEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Avion.class, avionEditor);
        binder.registerCustomEditor(Pilote.class, piloteEditor);
    }

    @Autowired
    public PiloterController(
            IModelService<Piloter> piloterService,
            IModelService<Avion> avionService,
            IModelService<Pilote> piloteService,
            IModelPropertyEditor<Avion> avionEditor,
            IModelPropertyEditor<Pilote> piloteEditor
    ) {
        this.piloterService = piloterService;
        this.avionService = avionService;
        this.piloteService = piloteService;
        this.avionEditor = avionEditor;
        this.piloteEditor = piloteEditor;
    }

    @GetMapping("/listePiloter")
    public String viewPiloters(Model model) {
        List<Piloter> listePiloter = piloterService.getAll();
        model.addAttribute("listePiloter", listePiloter);
        return "piloter/listePiloter";
    }

    @GetMapping("/piloter/{id}")
    public String viewPiloter(@PathVariable(value = "id") int id, Model model) {
        Piloter piloter = piloterService.getWithRelations(id);
        model.addAttribute("piloter", piloter);
        return "piloter/piloter";
    }

    @GetMapping("/add")
    public String showNewPiloterForm(Model model) {
        Piloter piloter = new Piloter();
        model.addAttribute("piloter", piloter);

        Collection<Avion> avions = avionService.getAll();
        model.addAttribute("avions", avions);

        Collection<Pilote> pilotes = piloteService.getAll();
        model.addAttribute("pilotes", pilotes);

        return "piloter/addPiloter";
    }

    @PostMapping("/save")
    public String savePiloter(@Valid @ModelAttribute("piloter") Piloter piloter, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            Collection<Avion> avions = avionService.getAll();
            model.addAttribute("avions", avions);

            Collection<Pilote> pilotes = piloteService.getAll();
            model.addAttribute("pilotes", pilotes);

            return "piloter/addPiloter";
        }

        piloterService.persist(piloter);
        return "redirect:/piloter/piloter/" + piloter.getId();
    }

    @GetMapping("/delete/{id}")
    public String deletePiloter(@PathVariable (value = "id") int id) {
        piloterService.delete(id);
        return "redirect:/piloter/listePiloter";
    }
}
