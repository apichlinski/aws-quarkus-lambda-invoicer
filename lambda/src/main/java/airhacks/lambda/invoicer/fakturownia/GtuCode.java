package airhacks.lambda.invoicer.fakturownia;

enum GtuCode {
    GTU_1("GTU_1"),
    GTU_2("GTU_2"),
    GTU_3("GTU_3"),
    GTU_4("GTU_4"),
    GTU_5("GTU_5"),
    GTU_6("GTU_6"),
    GTU_7("GTU_7"),
    GTU_8("GTU_8"),
    GTU_9("GTU_9"),
    GTU_10("GTU_10"),
    GTU_11("GTU_11"),
    GTU_12("GTU_12");

    private String value;

    GtuCode(String value) {
        this.value = value;
    }
}

