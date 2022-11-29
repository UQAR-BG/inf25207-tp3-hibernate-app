package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.*;
import com.inf25207.tp3.services.interfaces.IModelService;
import com.inf25207.tp3.services.interfaces.IUniqueRelationService;
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

    @GetMapping("/piloter")
    public String viewPiloter(@RequestParam(value = "avion_matricule") int avionMatricule, @RequestParam(value = "pilote_matricule") int piloteMatricule, Model model) {
        Piloter piloter = ((IUniqueRelationService<Piloter>)piloterService).get(piloteMatricule, avionMatricule);

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
        if (!result.hasErrors()) {
            if (piloterService.persist(piloter)) {
                return "redirect:/piloter/piloter?avion_matricule=" + piloter.getAvion().getMatricule() + "&pilote_matricule=" + piloter.getPilote().getMatricule();
            }

            result.rejectValue("avion", "error.avion", "Cette relation existe déjà.");
        }

        Collection<Avion> avions = avionService.getAll();
        model.addAttribute("avions", avions);

        Collection<Pilote> pilotes = piloteService.getAll();
        model.addAttribute("pilotes", pilotes);

        return "piloter/addPiloter";
    }

    @GetMapping("/delete/{id}")
    public String deletePiloter(@PathVariable (value = "id") int id) {
        piloterService.delete(id);
        return "redirect:/piloter/listePiloter";
    }

    @GetMapping("/delete")
    public String deleteSpecialisation(@RequestParam(value = "avion_matricule") int avionMatricule, @RequestParam(value = "pilote_matricule") int piloteMatricule) {
        ((IUniqueRelationService<Piloter>)piloterService).delete(piloteMatricule, avionMatricule);
        return "redirect:/piloter/listePiloter";
    }
}
