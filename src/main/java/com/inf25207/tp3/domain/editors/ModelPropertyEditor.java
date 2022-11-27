package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.services.interfaces.IModelService;

import java.beans.PropertyEditorSupport;

/*
 * Auteur: Jerome Dalbert
 * Source: https://stackoverflow.com/questions/12875299/spring-mvc-formselect-tag
 */

public abstract class ModelPropertyEditor<T> extends PropertyEditorSupport {
    protected IModelService<T> service;

    @Override
    public void setAsText(String text) {
        T model = service.get(Integer.parseInt(text));

        this.setValue(model);
    }
}
