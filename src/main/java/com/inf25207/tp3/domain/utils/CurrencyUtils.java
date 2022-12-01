package com.inf25207.tp3.domain.utils;

import java.text.NumberFormat;

/**
 * @author de référence arshajii
 * @author Bastien Goulet
 * Source: https://stackoverflow.com/questions/13791409/java-format-double-value-as-dollar-amount
* */

public class CurrencyUtils {

    public static String getCurrency(Double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(amount);
    }
}
