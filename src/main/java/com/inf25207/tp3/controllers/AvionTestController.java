package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.AvionTest;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/avion_test")
public class AvionTestController {
    private final IModelService<AvionTest> avionTestService;

    @Autowired
    public AvionTestController(IModelService<AvionTest> avionTestService) {
        this.avionTestService = avionTestService;
    }

    @GetMapping("/avion_tests")
    public String viewAvionTests(Model model) {
        return "avion_tests";
    }

    @GetMapping("/add")
    public String showNewAvionTestForm(Model model) {
        AvionTest avionTest = new AvionTest();
        model.addAttribute("avion_test", avionTest);
        return "new_avion_test";
    }

    @PostMapping("/save")
    public String saveAvionTest(@ModelAttribute("avion_test") AvionTest avionTest) {
        avionTestService.persist(avionTest);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        AvionTest avionTest = avionTestService.getWithRelations(id);
        model.addAttribute("avion_test", avionTest);
        return "update_avion_test";
    }

    @GetMapping("/delete/{id}")
    public String deleteAvionTest(@PathVariable (value = "id") int id) {
        avionTestService.delete(id);
        return "redirect:/";
    }
}
