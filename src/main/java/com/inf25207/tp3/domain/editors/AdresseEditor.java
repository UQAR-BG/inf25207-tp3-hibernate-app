package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.services.interfaces.IAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.util.Collection;
import java.util.Objects;

/*
 * Auteur: Jerome Dalbert
 * Source: https://stackoverflow.com/questions/12875299/spring-mvc-formselect-tag
 */

@Component
public class AdresseEditor extends PropertyEditorSupport {
    @Autowired
    private IAdresseService adresseService;

    @Override
    public void setAsText(String text) {
        //Adresse adresse = adresseService.getAdresse(Integer.parseInt(text));
        Collection<Adresse> adresses = adresseService.getAdresses();
        Adresse adresse = adresses
                .stream()
                .filter(a -> Objects.equals(a.getId(), Integer.parseInt(text)))
                .findFirst()
                .orElse(null);

        this.setValue(adresse);
    }
}

