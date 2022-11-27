package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Examen;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "examenEditor")
public class ExamenEditor extends ModelPropertyEditor<Examen> {
    @Autowired
    public ExamenEditor(IModelService<Examen> examenService) {
        this.service = examenService;
    }
}

