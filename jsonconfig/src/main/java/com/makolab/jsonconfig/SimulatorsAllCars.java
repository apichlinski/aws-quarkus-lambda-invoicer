package com.makolab.jsonconfig;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class SimulatorsAllCars {
    @Id
    Long id;
    String environment;
    String country;
    String brand;
    String request;
}
