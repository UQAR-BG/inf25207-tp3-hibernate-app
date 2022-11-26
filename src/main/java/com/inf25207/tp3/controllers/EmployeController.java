package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.services.interfaces.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employe")
public class EmployeController {
    private final IEmployeService EmployeService;

    @Autowired
    public EmployeController(IEmployeService EmployeService) {
        this.EmployeService = EmployeService;
    }

    @GetMapping("/employes")
    public String viewEmployes(Model model) {
        return "employes";
    }

    @GetMapping("/add")
    public String showNewEmployeForm(Model model) {
        Employe Employe = new Employe();
        model.addAttribute("employe", Employe);
        return "new_employe";
    }

    @PostMapping("/save")
    public String saveEmploye(@ModelAttribute("employe") Employe Employe) {
        EmployeService.addEmploye(Employe);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Employe Employe = EmployeService.getEmploye(id);
        model.addAttribute("employe", Employe);
        return "update_employe";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable (value = "id") int id) {
        EmployeService.deleteEmploye(id);
        return "redirect:/";
    }
}
