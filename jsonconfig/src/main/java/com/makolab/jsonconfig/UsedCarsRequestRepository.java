package com.makolab.jsonconfig;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class UsedCarsRequestRepository implements PanacheRepository<UsedCarsRequest> {
    String findByBrandAndCountryAndEnvironment(String brand, String country, String environment) {
        UsedCarsRequest car = find("brand = ?1 and country = ?2 and environment = ?3", brand, country, environment).firstResult();
        return car != null ? car.request : null;
    }
}