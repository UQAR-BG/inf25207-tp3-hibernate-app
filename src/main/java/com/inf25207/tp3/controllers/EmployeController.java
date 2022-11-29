package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.domain.models.Employe;
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

@Controller
@RequestMapping("/employe")
public class EmployeController {
    private final IModelService<Employe> employeService;
    private final IModelService<Adresse> adresseService;
    private final IModelPropertyEditor<Adresse> adresseEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Adresse.class, adresseEditor);
    }

    @Autowired
    public EmployeController(
            IModelService<Employe> employeService,
            IModelService<Adresse> adresseService,
            IModelPropertyEditor<Adresse> adresseEditor
    ) {
        this.employeService = employeService;
        this.adresseService = adresseService;
        this.adresseEditor = adresseEditor;
    }

    @GetMapping("/employes")
    public String viewEmployes(Model model) {
        List<Employe> employes = employeService.getAll();
        model.addAttribute("employes", employes);
        return "employe/employes";
    }

    @GetMapping("/employe/{id}")
    public String viewEmploye(@PathVariable(value = "id") int id, Model model) {
        Employe employe = employeService.getWithRelations(id);
        model.addAttribute("employe", employe);
        model.addAttribute("isUpdating", false);
        return "employe/employe";
    }

    @GetMapping("/add")
    public String showNewEmployeForm(Model model) {
        Employe employe = new Employe();
        model.addAttribute("employe", employe);

        Collection<Adresse> adresses = adresseService.getAll();
        model.addAttribute("adresses", adresses);

        return "employe/addEmploye";
    }

    @PostMapping("/save")
    public String saveEmploye(@Valid @ModelAttribute("employe") Employe employe, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            Collection<Adresse> adresses = adresseService.getAll();
            model.addAttribute("adresses", adresses);

            return "employe/addEmploye";
        }
        employeService.persist(employe);
        return "redirect:/employe/employe/" + employe.getMatricule();
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {
        Employe employe = employeService.getWithRelations(id);
        model.addAttribute("employe", employe);
        model.addAttribute("isUpdating", true);

        Collection<Adresse> adresses = adresseService.getAll();
        model.addAttribute("adresses", adresses);

        return "employe/employe";
    }

    @PostMapping("/save/{id}")
    public String updateEmploye(@PathVariable( value = "id") int id, @Valid @ModelAttribute("employe") Employe employe, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("isUpdating", true);
            return "employe/employe";
        }

        employe.setMatricule(id);
        employe = employeService.update(employe);

        model.addAttribute("isUpdating", false);
        return "redirect:/employe/employe/" + employe.getMatricule();
    }

    @GetMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable (value = "id") int id) {
        employeService.delete(id);
        return "redirect:/employe/employes";
    }
}
