package airhacks.lambda.invoicer.fakturownia;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/invoices.json")
@RegisterRestClient(configKey = "fakturownia")
@RegisterProvider(FakturowniaClientExceptionMapper.class)
interface FakturowniaClient {

    @POST
    @ClientHeaderParam(name = "Content-Type", value = "application/json")
    @ClientHeaderParam(name = "Accept", value = "application/json")
    InvoiceDTO sendInvoice(InvoiceRequestDTO request);
/*
    @ResponseExceptionMapper
    static RuntimeException toException(Response response) {
        if (response.getStatus() > 201) {
            return new RuntimeException(response.readEntity(ErrorResponse.class).getMessage());
        }
        return null;
    }*/
}