package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Type;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "types";
    }

    @GetMapping("/add")
    public String showNewTypeForm(Model model) {
        Type Type = new Type();
        model.addAttribute("type", Type);
        return "new_type";
    }

    @PostMapping("/save")
    public String saveType(@ModelAttribute("type") Type Type) {
        typeService.persist(Type);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Type Type = typeService.getWithRelations(id);
        model.addAttribute("type", Type);
        return "update_type";
    }

    @GetMapping("/delete/{id}")
    public String deleteType(@PathVariable (value = "id") int id) {
        typeService.delete(id);
        return "redirect:/";
    }
}
