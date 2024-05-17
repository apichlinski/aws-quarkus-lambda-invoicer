package com.github.apichlinski.invoicer.fakturownia;

enum Kind {
    VAT("vat");

    private String value;

    Kind(String value) {
        this.value = value;
    }
}