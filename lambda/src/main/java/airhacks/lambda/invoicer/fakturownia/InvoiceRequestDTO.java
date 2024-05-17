package airhacks.lambda.invoicer.fakturownia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
class InvoiceRequestDTO {
    @JsonProperty(value = "api_token")
    private String apiToken;
    private InvoiceDTO invoice;
}
