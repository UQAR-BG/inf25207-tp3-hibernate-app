package com.inf25207.tp3.domain.editors.interfaces;

import java.beans.PropertyEditor;

/**
 * @author Bastien Goulet
 * */

public interface IModelPropertyEditor<T> extends PropertyEditor {
    void setAsText(String text);
}
