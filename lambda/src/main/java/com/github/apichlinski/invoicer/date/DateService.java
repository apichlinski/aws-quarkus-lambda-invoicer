package com.github.apichlinski.invoicer.date;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class DateService {
    public LocalDate getLastDayOfCurrentMonth() {
        LocalDate today = LocalDate.now();
        return today.withDayOfMonth(today.lengthOfMonth());
    }

    public LocalDate addDaysToDate(int days, LocalDate date) {
        return date.plusDays(days);
    }

    public String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }
}
