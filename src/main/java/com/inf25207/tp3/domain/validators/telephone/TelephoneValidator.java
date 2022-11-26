package com.inf25207.tp3.domain.validators.telephone;

/*
 * Auteur: Ashish Agre (silentsudo)
 * Source: https://gist.github.com/silentsudo/26aa39eaf7c5a0235e89469d809ab9d3
 */


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelephoneValidator implements ConstraintValidator<Telephone, String> {
    private final TelephoneRegexMatcher telephoneRegexMatcher;

    public TelephoneValidator() {
        telephoneRegexMatcher = new TelephoneRegexMatcher();
    }

    @Override
    public boolean isValid(String telephone, ConstraintValidatorContext constraintValidatorContext) {
        return telephoneRegexMatcher.isValid(telephone);
    }
}
