package com.inf25207.tp3.domain.editors;

import com.inf25207.tp3.domain.models.Test;
import com.inf25207.tp3.services.interfaces.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Bastien Goulet
 * */
@Component(value = "testEditor")
public class TestEditor extends ModelPropertyEditor<Test> {
    @Autowired
    public TestEditor(IModelService<Test> testService) {
        this.service = testService;
    }
}

