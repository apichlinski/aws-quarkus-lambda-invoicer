package com.makolab.jsonconfig;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class JsonConfigResourceIT {
    @Test
    void testFetchCarEndpoint_success() {
        given()
                .when().get("/jsonconfig?brand=toyota&country=at&environment=DEV_1&carType=uc")
                .then()
                .statusCode(200)
                .body(containsString("\"country\": \"at\""));
    }

    @Test
    void testFetchCarEndpoint_invalidCarType() {
        given()
                .when().get("/jsonconfig?brand=toyota&country=at&environment=DEV_1&carType=aa")
                .then()
                .statusCode(400)
                .body(containsString(JsonConfigService.INVALID_CAR_TYPE_MESSAGE));
    }

    @Test
    void testFetchCarEndpoint_notFound() {
        given()
                .when().get("/jsonconfig?brand=toyota&country=gg&environment=DEV_1&carType=nc")
                .then()
                .statusCode(404)
                .body(containsString(JsonConfigService.NOT_FOUND_MESSAGE));
    }

}