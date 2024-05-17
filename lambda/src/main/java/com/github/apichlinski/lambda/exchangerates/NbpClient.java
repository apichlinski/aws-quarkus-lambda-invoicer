package com.github.apichlinski.lambda.exchangerates;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/exchangerates")
@RegisterRestClient(configKey = "extensions-api")
public interface NbpClient {

    @GET
    @Path("/tables/c")
    List<Table> getExchangeRates();

}
