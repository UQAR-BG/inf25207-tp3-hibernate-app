package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Type;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "typeEditor")
public class TypeEditor extends ModelPropertyEditor<Type> {
    @Autowired
    public TypeEditor(IModelService<Type> typeService) {
        this.service = typeService;
    }
}

