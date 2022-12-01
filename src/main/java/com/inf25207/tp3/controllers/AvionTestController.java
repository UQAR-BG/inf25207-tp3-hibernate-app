package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.*;
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

/**
 * @author Bastien Goulet
 * */

@Controller
@RequestMapping("/avionTest")
public class AvionTestController {
    private final IModelService<AvionTest> avionTestService;
    private final IModelService<Avion> avionService;
    private final IModelService<Test> testService;
    private final IModelPropertyEditor<Avion> avionEditor;
    private final IModelPropertyEditor<Test> testEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Avion.class, avionEditor);
        binder.registerCustomEditor(Test.class, testEditor);
    }

    @Autowired
    public AvionTestController(
            IModelService<AvionTest> avionTestService,
            IModelService<Avion> avionService,
            IModelService<Test> testService,
            IModelPropertyEditor<Avion> avionEditor,
            IModelPropertyEditor<Test> testEditor
    ) {
        this.avionTestService = avionTestService;
        this.avionService = avionService;
        this.testService = testService;
        this.avionEditor = avionEditor;
        this.testEditor = testEditor;
    }

    @GetMapping("/avionTests")
    public String viewAvionTests(Model model) {
        List<AvionTest> avionTests = avionTestService.getAll();
        model.addAttribute("avionTests", avionTests);
        return "avionTest/avionTests";
    }

    @GetMapping("/avionTest/{id}")
    public String viewAvionTest(@PathVariable(value = "id") int id, Model model) {
        AvionTest avionTest = avionTestService.getWithRelations(id);
        model.addAttribute("avionTest", avionTest);
        return "avionTest/avionTest";
    }

    @GetMapping("/add")
    public String showNewAvionTestForm(Model model) {
        AvionTest avionTest = new AvionTest();
        model.addAttribute("avionTest", avionTest);

        Collection<Avion> avions = avionService.getAll();
        model.addAttribute("avions", avions);

        Collection<Test> tests = testService.getAll();
        model.addAttribute("tests", tests);

        return "avionTest/addAvionTest";
    }

    @PostMapping("/save")
    public String saveAvionTest(@Valid @ModelAttribute("avionTest") AvionTest avionTest, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            Collection<Avion> avions = avionService.getAll();
            model.addAttribute("avions", avions);

            Collection<Test> tests = testService.getAll();
            model.addAttribute("tests", tests);

            return "avionTest/addAvionTest";
        }
        avionTestService.persist(avionTest);
        return "redirect:/avionTest/avionTest/" + avionTest.getId();
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        AvionTest avionTest = avionTestService.getWithRelations(id);
        model.addAttribute("avionTest", avionTest);
        model.addAttribute("isUpdating", true);

        Collection<Avion> avions = avionService.getAll();
        model.addAttribute("avions", avions);

        Collection<Test> tests = testService.getAll();
        model.addAttribute("tests", tests);

        return "avionTest/avionTest";
    }

    @PostMapping("/save/{id}")
    public String updateAvionTest(@PathVariable( value = "id") int id, @Valid @ModelAttribute("avionTest") AvionTest avionTest, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("isUpdating", true);
            return "avionTest/avionTest";
        }

        avionTest.setId(id);
        avionTest = avionTestService.update(avionTest);

        model.addAttribute("isUpdating", false);
        return "redirect:/avionTest/avionTest/" + avionTest.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteAvionTest(@PathVariable (value = "id") int id) {
        avionTestService.delete(id);
        return "redirect:/avionTest/avionTests";
    }
}
