package airhacks.lambda.invoicer;

public interface CreateInvoice {
    CreateInvoiceResponse createNewInvoice(Integer hours);
}
