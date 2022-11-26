package com.inf25207.tp3.domain.validators.telephone;

/*
 * Auteur: Ashish Agre (silentsudo)
 * Source: https://gist.github.com/silentsudo/26aa39eaf7c5a0235e89469d809ab9d3
 */

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {TelephoneValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Telephone {
    String message() default "Le numéro de téléphone fourni n'est pas valide.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}