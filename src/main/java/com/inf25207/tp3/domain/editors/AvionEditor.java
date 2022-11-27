package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Avion;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "avionEditor")
public class AvionEditor extends ModelPropertyEditor<Avion> {
    @Autowired
    public AvionEditor(IModelService<Avion> avionService) {
        this.service = avionService;
    }
}

