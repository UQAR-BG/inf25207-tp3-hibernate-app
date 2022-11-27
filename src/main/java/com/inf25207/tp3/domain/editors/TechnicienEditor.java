package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Technicien;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "technicienEditor")
public class TechnicienEditor extends ModelPropertyEditor<Technicien> {
    @Autowired
    public TechnicienEditor(IModelService<Technicien> technicienService) {
        this.service = technicienService;
    }
}

