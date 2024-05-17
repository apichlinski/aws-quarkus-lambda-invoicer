package airhacks.lambda.invoicer.fakturownia;

enum PaymentType {
    TRANSFER("transfer");

    private String value;

    PaymentType(String value) {
        this.value = value;
    }
}
