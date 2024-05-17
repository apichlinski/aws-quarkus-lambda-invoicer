package airhacks.lambda.invoicer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/invoicer")
@ApplicationScoped
public class InvoicerResource {
    @Inject
    CreateInvoice createInvoice;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CreateInvoiceResponse exchangeRates(@QueryParam("hours") Integer hours) {
        return createInvoice.createNewInvoice(hours);
    }
}
