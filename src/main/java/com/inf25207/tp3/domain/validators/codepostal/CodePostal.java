package com.inf25207.tp3.domain.validators.codepostal;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Auteur: Ashish Agre (silentsudo)
 * Source: https://gist.github.com/silentsudo/26aa39eaf7c5a0235e89469d809ab9d3
 */

@Constraint(validatedBy = {CodePostalValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CodePostal {
    String message() default "Le code postal fourni n'est pas valide. (A0A 0A0)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}