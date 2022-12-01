package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Bastien Goulet
 * */

@Component(value = "adresseEditor")
public class AdresseEditor extends ModelPropertyEditor<Adresse> {
    @Autowired
    public AdresseEditor(IModelService<Adresse> adresseService) {
        this.service = adresseService;
    }
}

