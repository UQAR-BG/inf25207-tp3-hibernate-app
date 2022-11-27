package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Test;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {
    private final IModelService<Test> testService;

    @Autowired
    public TestController(IModelService<Test> testService) {
        this.testService = testService;
    }

    @GetMapping("/tests")
    public String viewTests(Model model) {
        return "tests";
    }

    @GetMapping("/add")
    public String showNewTestForm(Model model) {
        Test Test = new Test();
        model.addAttribute("test", Test);
        return "new_test";
    }

    @PostMapping("/save")
    public String saveTest(@ModelAttribute("test") Test Test) {
        testService.persist(Test);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Test Test = testService.getWithRelations(id);
        model.addAttribute("test", Test);
        return "update_test";
    }

    @GetMapping("/delete/{id}")
    public String deleteTest(@PathVariable (value = "id") int id) {
        testService.delete(id);
        return "redirect:/";
    }
}
