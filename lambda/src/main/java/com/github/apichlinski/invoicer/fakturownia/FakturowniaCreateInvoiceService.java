package com.github.apichlinski.invoicer.fakturownia;

import com.github.apichlinski.invoicer.CreateInvoice;
import com.github.apichlinski.invoicer.CreateInvoiceResponse;
import com.github.apichlinski.invoicer.date.DateService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class FakturowniaCreateInvoiceService implements CreateInvoice {
    @RestClient
    FakturowniaClient fakturowniaClient;
    @Inject
    DateService dateService;
    @ConfigProperty(name = "fakturownia.api_token")
    private String apiToken;
    @ConfigProperty(name = "fakturownia.kind")
    private Kind kind;
    @ConfigProperty(name = "fakturownia.place")
    private String place;
    @ConfigProperty(name = "fakturownia.payment_to_kind")
    private int paymentToKind;
    @ConfigProperty(name = "fakturownia.payment_type")
    private PaymentType paymwentType;
    @ConfigProperty(name = "fakturownia.client_id")
    private String clientId;
    @ConfigProperty(name = "fakturownia.gtu_code")
    private GtuCode gtuCode;

    @ConfigProperty(name = "fakturownia.service_name")
    private String serviceName;
    @ConfigProperty(name = "fakturownia.service_quantity")
    private int serviceQuantity;
    @ConfigProperty(name = "fakturownia.service_productId")
    private Long serviceId;

    @Override
    public CreateInvoiceResponse createNewInvoice(Integer hours) {
        if (hours == null) {
            hours = 168;
        }
        System.out.println(createInvoiceRequest(hours));
        CreateInvoiceResponse response;
        try {
            response = fakturowniaClient.sendInvoice(createInvoiceRequest(hours));
            System.out.println(response);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            response = ErrorResponse.builder()
                    .code("400")
                    .message(exception.getMessage())
                    .build();
        }
        return response;
    }

    private InvoiceRequestDTO createInvoiceRequest(int hours) {
        return InvoiceRequestDTO
                .builder()
                .apiToken(apiToken)
                .invoice((createInvoice(hours)))
                .build();
    }

    private InvoiceDTO createInvoice(int hours) {
        LocalDate issueDate = dateService.getLastDayOfCurrentMonth();
        LocalDate paymentTo = dateService.addDaysToDate(paymentToKind, issueDate);
        return InvoiceDTO
                .builder()
                .kind(kind)
                .place(place)
                .sellDate(issueDate)
                .issueDate(issueDate)
                .paymentTo(paymentTo)
                .paymentToKind(paymentToKind)
                .paymentType(paymwentType)
                .clientId(clientId)
                .gtuCodes(createGtuCodes())
                .positions(createPositions(hours))
                .build();
    }

    private List<GtuCode> createGtuCodes() {
        return List.of(gtuCode);
    }

    private List<Position> createPositions(int hours) {
        return List.of(Position.builder()
                .productId(serviceId)
                .quantity(serviceQuantity)
                .name(serviceName.formatted("maj", hours))
                .build());
    }
}