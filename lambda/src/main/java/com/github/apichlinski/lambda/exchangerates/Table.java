package com.github.apichlinski.lambda.exchangerates;

import java.time.LocalDate;
import java.util.List;

public class Table {
    public TableType table;
    public String no;
    public LocalDate tradingDate;
    public LocalDate effectiveDate;
    public List<Rate> rates;
}
