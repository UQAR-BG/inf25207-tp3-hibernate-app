package com.inf25207.tp3.controllers;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.domain.models.Technicien;
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
@RequestMapping("/technicien")
public class TechnicienController {
    private final IModelService<Technicien> technicienService;
    private final IModelService<Employe> employeService;
    private final IModelPropertyEditor<Employe> employeEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Employe.class, employeEditor);
    }

    @Autowired
    public TechnicienController(
            IModelService<Technicien> technicienService,
            IModelService<Employe> employeService,
            IModelPropertyEditor<Employe> employeEditor
    ) {
        this.technicienService = technicienService;
        this.employeService = employeService;
        this.employeEditor = employeEditor;
    }

    @GetMapping("/techniciens")
    public String viewTechniciens(Model model) {
        List<Technicien> techniciens = technicienService.getAll();
        model.addAttribute("techniciens", techniciens);
        return "technicien/techniciens";
    }

    @GetMapping("/technicien/{id}")
    public String viewTechnicien(@PathVariable(value = "id") int id, Model model) {
        Technicien technicien = technicienService.getWithRelations(id);
        model.addAttribute("technicien", technicien);
        model.addAttribute("specialisations", technicien.getSpecialisations());
        model.addAttribute("reparations", technicien.getReparations());
        return "technicien/technicien";
    }

    @GetMapping("/add")
    public String showNewTechnicienForm(Model model) {
        Technicien Technicien = new Technicien();
        model.addAttribute("technicien", Technicien);

        Collection<Employe> employes = employeService.getAll();
        model.addAttribute("employes", employes);

        return "technicien/addTechnicien";
    }

    @PostMapping("/save")
    public String saveTechnicien(@Valid @ModelAttribute("technicien") Technicien technicien, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "technicien/addTechnicien";
        }
        technicienService.persist(technicien);
        return "redirect:/technicien/technicien/" + technicien.getMatricule();
    }

    @GetMapping("/delete/{id}")
    public String deleteTechnicien(@PathVariable (value = "id") int id) {
        technicienService.delete(id);
        return "redirect:/technicien/techniciens";
    }
}
