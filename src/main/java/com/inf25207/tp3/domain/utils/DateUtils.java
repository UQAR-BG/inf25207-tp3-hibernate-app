package com.inf25207.tp3.domain.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author de référence baeldung
 * @author Bastien Goulet
 * Source: https://www.baeldung.com/java-date-to-localdate-and-localdatetime
* */

public class DateUtils {

    public static LocalDate getLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
