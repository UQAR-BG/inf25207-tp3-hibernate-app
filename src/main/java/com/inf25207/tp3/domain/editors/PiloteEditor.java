package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Pilote;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Bastien Goulet
 * */

@Component(value = "piloteEditor")
public class PiloteEditor extends ModelPropertyEditor<Pilote> {
    @Autowired
    public PiloteEditor(IModelService<Pilote> piloteService) {
        this.service = piloteService;
    }
}

