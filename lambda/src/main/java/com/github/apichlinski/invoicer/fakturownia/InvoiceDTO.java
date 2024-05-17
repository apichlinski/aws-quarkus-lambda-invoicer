package com.github.apichlinski.invoicer.fakturownia;

import com.github.apichlinski.invoicer.CreateInvoiceResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
class InvoiceDTO implements CreateInvoiceResponse {
    private Kind kind;
    private String place;
    @JsonProperty("sell_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate sellDate;
    @JsonProperty("issue_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate issueDate;
    @JsonProperty("payment_to")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentTo;
    @JsonProperty("payment_to_kind")
    private int paymentToKind;
    @JsonProperty("payment_type")
    private PaymentType paymentType;
    @JsonProperty("client_id")
    private String clientId;
    private List<Position> positions;
    private String currency;
    private String lang;
    @JsonProperty("view_url")
    private String viewUrl;
    @JsonProperty("gtu_codes")
    private List<GtuCode> gtuCodes;
}
