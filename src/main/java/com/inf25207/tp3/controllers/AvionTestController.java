package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.AvionTest;
import com.inf25207.tp3.services.interfaces.IAvionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/avion_test")
public class AvionTestController {
    private final IAvionTestService AvionTestService;

    @Autowired
    public AvionTestController(IAvionTestService AvionTestService) {
        this.AvionTestService = AvionTestService;
    }

    @GetMapping("/avion_tests")
    public String viewAvionTests(Model model) {
        return "avion_tests";
    }

    @GetMapping("/add")
    public String showNewAvionTestForm(Model model) {
        AvionTest AvionTest = new AvionTest();
        model.addAttribute("avion_test", AvionTest);
        return "new_avion_test";
    }

    @PostMapping("/save")
    public String saveAvionTest(@ModelAttribute("avion_test") AvionTest AvionTest) {
        AvionTestService.addAvionTest(AvionTest);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        AvionTest AvionTest = AvionTestService.getAvionTest(id);
        model.addAttribute("avion_test", AvionTest);
        return "update_avion_test";
    }

    @GetMapping("/delete/{id}")
    public String deleteAvionTest(@PathVariable (value = "id") int id) {
        AvionTestService.deleteAvionTest(id);
        return "redirect:/";
    }
}
