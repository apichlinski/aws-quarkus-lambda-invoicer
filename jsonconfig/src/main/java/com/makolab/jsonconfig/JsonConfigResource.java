package com.makolab.jsonconfig;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.Optional;

@Path("jsonconfig")
class JsonConfigResource {

    @Inject
    JsonConfigService jsonConfigService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<String> fetchRequest(@QueryParam("brand") String brand, @QueryParam("country")String country, @QueryParam("environment") String environment, @QueryParam("carType")Optional<String> carType) {
        return jsonConfigService.fetchConfig(brand, country, environment, carType.orElse("nc"));
    }
}
