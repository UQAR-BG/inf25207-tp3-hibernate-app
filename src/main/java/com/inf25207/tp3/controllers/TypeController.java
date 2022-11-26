package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Type;
import com.inf25207.tp3.services.interfaces.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/type")
public class TypeController {
    private final ITypeService TypeService;

    @Autowired
    public TypeController(ITypeService TypeService) {
        this.TypeService = TypeService;
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
        TypeService.addType(Type);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Type Type = TypeService.getType(id);
        model.addAttribute("type", Type);
        return "update_type";
    }

    @GetMapping("/delete/{id}")
    public String deleteType(@PathVariable (value = "id") int id) {
        TypeService.deleteType(id);
        return "redirect:/";
    }
}
