package com.inf25207.tp3.domain.validators.telephone;

import java.util.regex.Pattern;

/*
 * Auteur: Ashish Agre (silentsudo)
 * Source: https://gist.github.com/silentsudo/26aa39eaf7c5a0235e89469d809ab9d3
 */


public class TelephoneRegexMatcher {
    /*
     * Auteur: Ravi K Thapliyal
     * Source: https://stackoverflow.com/questions/16699007/regular-expression-to-match-standard-10-digit-phone-number
     * */
    public static final String TELEPHONE_REGEX = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
    private final Pattern pattern;

    public TelephoneRegexMatcher() {
        pattern = Pattern.compile(TELEPHONE_REGEX);
    }

    public boolean isValid(String telephone) {
        return pattern.matcher(telephone).matches();
    }
}