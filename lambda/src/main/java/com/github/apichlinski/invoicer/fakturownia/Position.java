package com.github.apichlinski.invoicer.fakturownia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
class Position {
    private Long id;
    @JsonProperty("invoice_id")
    private Long invoiceId;
    @JsonProperty("product_id")
    private Long productId;
    private String name;
    private String description;
    @JsonProperty("prive_net")
    private String priceNet;
    private int quantity;
    @JsonProperty("total_price_gross")
    private String totalPriceGross;
    @JsonProperty("total_price_net")
    private String totalPriceNet;
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("additionalInfo")
    private String additional_info;
    @JsonProperty("quantity_info")
    private String quantityInfo;
    private String tax;
    @JsonProperty("price_gross")
    private String priceGross;
    @JsonProperty("price_tax")
    private String priceTtax;
    @JsonProperty("total_price_tax")
    private String total_price_tax;
    private String kind;
    private boolean deleted;
    private String discount;
    private String percentage;
    private String tax2;
    private String code;
    @JsonProperty("exchange_rate")
    private String exchangeRate;
    @JsonProperty("additional_fields")
    private AdditionalField additionalFields;
    @JsonProperty("discount_net")
    private String discountNet;
}
