package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Type;
import com.inf25207.tp3.services.interfaces.IModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {
    private final IModelService<Type> typeService;

    @Autowired
    public TypeController(IModelService<Type> typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/types")
    public String viewTypes(Model model) {
        List<Type> types = typeService.getAll();
        model.addAttribute("types", types);
        return "type/types";
    }

    @GetMapping("/type/{id}")
    public String viewType(@PathVariable(value = "id") int id, Model model) {
        Type type = typeService.getWithRelations(id);
        model.addAttribute("type", type);
        model.addAttribute("pilotes", type.getPilotes());
        model.addAttribute("techniciens", type.getTechniciens());
        return "type/type";
    }

    @GetMapping("/add")
    public String showNewTypeForm(Model model) {
        Type type = new Type();
        model.addAttribute("type", type);

        return "type/addType";
    }

    @PostMapping("/save")
    public String saveType(@Valid @ModelAttribute("type") Type type, BindingResult result, ModelMap model) {
        if (!result.hasErrors()) {
            if (typeService.persist(type)) {
                return "redirect:/type/type/" + type.getId();
            }

            result.rejectValue("nom", "error.nom", "Un autre type possède déjà ce nom.");
        }

        return "type/addType";
    }

    @GetMapping("/delete/{id}")
    public String deleteType(@PathVariable (value = "id") int id) {
        typeService.delete(id);
        return "redirect:/type/types";
    }
}
