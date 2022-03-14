package com.lp.birthday.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeParse {
    public static LocalDate parseToLocalDate(String date) {
        LocalDate parseDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        try {
            parseDate = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException ex) {
            System.out.println("Date format incorrect.");
            parseDate = LocalDate.now();
        }
        return parseDate;
    }
}
