package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/*
 * Auteur: Jerome Dalbert
 * Source: https://stackoverflow.com/questions/12875299/spring-mvc-formselect-tag
 */

@Component
public class AdresseEditor extends PropertyEditorSupport {
    @Autowired
    private IModelService<Adresse> adresseService;

    @Override
    public void setAsText(String text) {
        Adresse adresse = adresseService.get(Integer.parseInt(text));

        this.setValue(adresse);
    }
}

