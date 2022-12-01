package com.inf25207.tp3.domain.validators.codepostal;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author de référence Ashish Agre (silentsudo)
 * @author Bastien Goulet
 * Source: https://gist.github.com/silentsudo/26aa39eaf7c5a0235e89469d809ab9d3
 */

public class CodePostalValidator implements ConstraintValidator<CodePostal, String> {
    private final CodePostalRegexMatcher codePostalRegexMatcher;

    public CodePostalValidator() {
        codePostalRegexMatcher = new CodePostalRegexMatcher();
    }

    @Override
    public boolean isValid(String codePostal, ConstraintValidatorContext constraintValidatorContext) {
        return codePostalRegexMatcher.isValid(codePostal);
    }
}
