package com.github.apichlinski.lambda.exchangerates;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/exchangerates")
@ApplicationScoped
public class ExchangeRatesResource {

    @Inject
    ExchangeRatesService exchangeRatesService;

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Rate> getExchangeRates() {
        return exchangeRatesService.getExchangeRates();
    }

    @GET
    @Path("/{currency}")
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Rate> getExchangeRate(@PathParam String currency) {
        return exchangeRatesService.getExchangeRates(currency);
    }
}
