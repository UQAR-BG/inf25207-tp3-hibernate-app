package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.services.interfaces.IEmployeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employe")
public class EmployeController {
    private final IEmployeService employeService;

    @Autowired
    public EmployeController(IEmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/employes")
    public String viewEmployes(Model model) {
        List<Employe> employes = employeService.getEmployes();
        model.addAttribute("employes", employes);
        return "employe/employes";
    }

    @GetMapping("/employe/{id}")
    public String viewEmploye(@PathVariable(value = "id") int id, Model model) {
        Employe employe = employeService.getEmploye(id);
        model.addAttribute("employe", employe);
        return "employe/employe";
    }

    @GetMapping("/add")
    public String showNewEmployeForm(Model model) {
        Employe employe = new Employe();
        model.addAttribute("employe", employe);
        return "employe/addEmploye";
    }

    @PostMapping("/save")
    public String saveEmploye(@Valid @ModelAttribute("employe") Employe employe, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "employe/addEmploye";
        }
        employeService.addEmploye(employe);
        return "redirect:/employe/employe/" + employe.getMatricule();
    }

    @GetMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable (value = "id") int id) {
        employeService.deleteEmploye(id);
        return "redirect:/employe/employes";
    }
}
