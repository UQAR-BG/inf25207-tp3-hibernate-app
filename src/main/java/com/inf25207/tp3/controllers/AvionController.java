package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.Avion;
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
@RequestMapping("/avion")
public class AvionController {
    private final IModelService<Avion> avionService;
    private final IModelService<Type> typeService;
    private final IModelPropertyEditor<Type> typeEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Type.class, typeEditor);
    }

    @Autowired
    public AvionController(
            IModelService<Avion> avionService,
            IModelService<Type> typeService,
            IModelPropertyEditor<Type> typeEditor
    ) {
        this.avionService = avionService;
        this.typeService = typeService;
        this.typeEditor = typeEditor;
    }

    @GetMapping("/avions")
    public String viewAvions(Model model) {
        List<Avion> avions = avionService.getAll();
        model.addAttribute("avions", avions);
        return "avion/avions";
    }

    @GetMapping("/avion/{id}")
    public String viewAvion(@PathVariable(value = "id") int id, Model model) {
        Avion avion = avionService.getWithRelations(id);
        model.addAttribute("avion", avion);
        model.addAttribute("avionTests", avion.getAvionTests());
        model.addAttribute("pilotes", avion.getPilotes());
        model.addAttribute("reparations", avion.getReparations());
        return "avion/avion";
    }

    @GetMapping("/add")
    public String showNewAvionForm(Model model) {
        Avion avion = new Avion();
        model.addAttribute("avion", avion);

        Collection<Type> types = typeService.getAll();
        model.addAttribute("types", types);

        return "avion/addAvion";
    }

    @PostMapping("/save")
    public String saveAvion(@Valid @ModelAttribute("avion") Avion avion, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "avion/addAvion";
        }
        avionService.persist(avion);
        return "redirect:/avion/avion/" + avion.getMatricule();
    }

    @GetMapping("/delete/{id}")
    public String deleteAvion(@PathVariable (value = "id") int id) {
        avionService.delete(id);
        return "redirect:/avion/avions";
    }
}
