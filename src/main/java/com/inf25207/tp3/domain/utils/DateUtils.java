package com.inf25207.tp3.domain.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/*
* Auteur: baeldung
* Source: https://www.baeldung.com/java-date-to-localdate-and-localdatetime
* */

public class DateUtils {

    public static LocalDate getLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
