package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Test;
import com.inf25207.tp3.services.interfaces.IModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bastien Goulet
 * */

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
        List<Test> tests = testService.getAll();
        model.addAttribute("tests", tests);
        return "test/tests";
    }

    @GetMapping("/test/{id}")
    public String viewTest(@PathVariable(value = "id") int id, Model model) {
        Test test = testService.getWithRelations(id);
        model.addAttribute("test", test);
        model.addAttribute("avionTests", test.getAvionTests());
        return "test/test";
    }

    @GetMapping("/add")
    public String showNewTestForm(Model model) {
        Test test = new Test();
        model.addAttribute("test", test);
        return "test/addTest";
    }

    @PostMapping("/save")
    public String saveTest(@Valid @ModelAttribute("test") Test test, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "test/addTest";
        }
        testService.persist(test);
        return "redirect:/test/test/" + test.getNumero();
    }

    @GetMapping("/delete/{id}")
    public String deleteTest(@PathVariable (value = "id") int id) {
        testService.delete(id);
        return "redirect:/test/tests";
    }
}
