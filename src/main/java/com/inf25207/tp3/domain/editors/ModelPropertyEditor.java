package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.editors.interfaces.IModelPropertyEditor;
import com.inf25207.tp3.services.interfaces.IModelService;

import java.beans.PropertyEditorSupport;

/**
 * @author de référence Jerome Dalbert
 * @author Bastien Goulet
 * Source: https://stackoverflow.com/questions/12875299/spring-mvc-formselect-tag
 */

public abstract class ModelPropertyEditor<T> extends PropertyEditorSupport implements IModelPropertyEditor<T> {
    protected IModelService<T> service;

    @Override
    public void setAsText(String text) {
        T model = service.get(Integer.parseInt(text));

        this.setValue(model);
    }
}
