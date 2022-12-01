package com.inf25207.tp3.domain.validators.codepostal;

import java.util.regex.Pattern;

/**
 * @author de référence Ashish Agre (silentsudo)
 * @author Bastien Goulet
 * Source: https://gist.github.com/silentsudo/26aa39eaf7c5a0235e89469d809ab9d3
 */

public class CodePostalRegexMatcher {
    /**
     * @author Kenneth K.
     * Source: https://stackoverflow.com/questions/15774555/efficient-regex-for-canadian-postal-code-function
     */
    public static final String CODE_POSTAL_REGEX = "^[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d$";
    private final Pattern pattern;

    public CodePostalRegexMatcher() {
        pattern = Pattern.compile(CODE_POSTAL_REGEX);
    }

    public boolean isValid(String codePostal) {
        return pattern.matcher(codePostal).matches();
    }
}