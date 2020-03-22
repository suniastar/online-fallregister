package de.coronavirus.application.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TimeConverter {

    public static Date convertLocalDateToDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
