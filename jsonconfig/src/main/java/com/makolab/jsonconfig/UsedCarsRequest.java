package com.makolab.jsonconfig;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "used_cars_request")
class UsedCarsRequest {
    @Id
    Long id;
    String environment;
    String country;
//    String language;
    String brand;
    String request;
}
