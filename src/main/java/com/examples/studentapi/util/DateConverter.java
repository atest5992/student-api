package com.examples.studentapi.util;

import lombok.experimental.UtilityClass;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateConverter {

    public static Date convertDate(String date) {
        final LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return Date.valueOf(parsedDate);
    }
}