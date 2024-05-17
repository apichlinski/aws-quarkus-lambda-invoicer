package airhacks.lambda.greetings.boundary;

import airhacks.lambda.exchangerates.NbpClient;
import airhacks.lambda.exchangerates.Table;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("hello")
@ApplicationScoped
public class GreetingResource {

    @Inject
    Greeter greeter;
    @Inject
    @RestClient
    NbpClient nbpClient;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void hello(String message) {
        this.greeter.greetings(message);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Table> exchangeRates() {
        return this.nbpClient.getExchangeRates();
    }
}