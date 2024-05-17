package com.github.apichlinski.invoicer.fakturownia;

import com.github.apichlinski.invoicer.CreateInvoiceResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
class ErrorResponse implements CreateInvoiceResponse {
    String code;
    String message;
}
