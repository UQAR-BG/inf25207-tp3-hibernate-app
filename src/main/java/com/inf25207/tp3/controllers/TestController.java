package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Test;
import com.inf25207.tp3.services.interfaces.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {
    private final ITestService TestService;

    @Autowired
    public TestController(ITestService TestService) {
        this.TestService = TestService;
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
        TestService.addTest(Test);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Test Test = TestService.getTest(id);
        model.addAttribute("test", Test);
        return "update_test";
    }

    @GetMapping("/delete/{id}")
    public String deleteTest(@PathVariable (value = "id") int id) {
        TestService.deleteTest(id);
        return "redirect:/";
    }
}
