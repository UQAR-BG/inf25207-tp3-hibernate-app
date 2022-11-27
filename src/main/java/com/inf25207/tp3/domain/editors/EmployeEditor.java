package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "employeEditor")
public class EmployeEditor extends ModelPropertyEditor<Employe> {
    @Autowired
    public EmployeEditor(IModelService<Employe> employeService) {
        this.service = employeService;
    }
}

