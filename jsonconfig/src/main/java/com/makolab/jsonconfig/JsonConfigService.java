package com.makolab.jsonconfig;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.Optional;

@ApplicationScoped
class JsonConfigService {

    static String NOT_FOUND_MESSAGE = "Car not found.";
    static String INVALID_CAR_TYPE_MESSAGE = "Car not found.";

    @Inject
    SimulatorsAllCarsRepository simulatorsAllCarsRepository;

    @Inject
    UsedCarsRequestRepository usedCarsRequestRepository;

    public RestResponse<String> fetchConfig(String brand, String country, String environment, String carType) {
        if ("nc".equalsIgnoreCase(carType)) {
            return Optional.ofNullable(simulatorsAllCarsRepository.findByBrandAndCountryAndEnvironment(brand, country, environment))
                    .map(RestResponse::ok)
                    .orElse(RestResponse.status(RestResponse.Status.NOT_FOUND, NOT_FOUND_MESSAGE));
        } else if ("uc".equalsIgnoreCase(carType)) {
            return Optional.ofNullable(usedCarsRequestRepository.findByBrandAndCountryAndEnvironment(brand, country, environment))
                    .map(RestResponse::ok)
                    .orElse(RestResponse.status(RestResponse.Status.NOT_FOUND, NOT_FOUND_MESSAGE));
        } else {
            return RestResponse.status(RestResponse.Status.BAD_REQUEST, INVALID_CAR_TYPE_MESSAGE);
        }
    }
}
