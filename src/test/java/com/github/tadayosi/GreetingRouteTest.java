package com.github.tadayosi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingRouteTest {

    @Test
    public void testHelloEndpoint() {
        given()
            .when().get("/hello/Camel")
            .then()
                .statusCode(200)
                .body(is("Hello Camel!"));
    }

    @Test
    public void testByeEndpoint() {
        given()
            .when().get("/bye/Camel")
            .then()
                .statusCode(200)
                .body(is("Bye Camel!"));
    }

}
