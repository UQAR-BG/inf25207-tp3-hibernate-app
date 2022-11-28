package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.Specialisation;
import com.inf25207.tp3.domain.models.Technicien;
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
@RequestMapping("/specialisation")
public class SpecialisationController {
    private final IModelService<Specialisation> specialisationService;
    private final IModelService<Type> typeService;
    private final IModelService<Technicien> technicienService;
    private final IModelPropertyEditor<Type> typeEditor;
    private final IModelPropertyEditor<Technicien> technicienEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Type.class, typeEditor);
        binder.registerCustomEditor(Technicien.class, technicienEditor);
    }

    @Autowired
    public SpecialisationController(
            IModelService<Specialisation> specialisationService,
            IModelService<Type> typeService,
            IModelService<Technicien> technicienService,
            IModelPropertyEditor<Type> typeEditor,
            IModelPropertyEditor<Technicien> technicienEditor
    ) {
        this.specialisationService = specialisationService;
        this.typeService = typeService;
        this.technicienService = technicienService;
        this.typeEditor = typeEditor;
        this.technicienEditor = technicienEditor;
    }

    @GetMapping("/specialisations")
    public String viewSpecialisations(Model model) {
        List<Specialisation> specialisations = specialisationService.getAll();
        model.addAttribute("specialisations", specialisations);
        return "specialisation/specialisations";
    }

    @GetMapping("/specialisation/{id}")
    public String viewSpecialisation(@PathVariable(value = "id") int id, Model model) {
        Specialisation specialisation = specialisationService.getWithRelations(id);
        model.addAttribute("specialisation", specialisation);
        return "specialisation/specialisation";
    }

    @GetMapping("/add")
    public String showNewSpecialisationForm(Model model) {
        Specialisation specialisation = new Specialisation();
        model.addAttribute("specialisation", specialisation);

        Collection<Type> types = typeService.getAll();
        model.addAttribute("types", types);

        Collection<Technicien> techniciens = technicienService.getAll();
        model.addAttribute("techniciens", techniciens);

        return "specialisation/addSpecialisation";
    }

    @PostMapping("/save")
    public String saveSpecialisation(@Valid @ModelAttribute("specialisation") Specialisation specialisation, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            Collection<Type> types = typeService.getAll();
            model.addAttribute("types", types);

            Collection<Technicien> techniciens = technicienService.getAll();
            model.addAttribute("techniciens", techniciens);

            return "specialisation/addSpecialisation";
        }
        specialisationService.persist(specialisation);
        return "redirect:/specialisation/specialisation/" + specialisation.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteSpecialisation(@PathVariable (value = "id") int id) {
        specialisationService.delete(id);
        return "redirect:/specialisation/specialisations";
    }
}
