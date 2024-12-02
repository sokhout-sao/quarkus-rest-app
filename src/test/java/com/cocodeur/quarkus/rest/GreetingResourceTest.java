package com.cocodeur.quarkus.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    @Test
    void testHelloEndpoint2() {
        given()
                .when().get("/api/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }


    @Test
    void testHelloEndpoint3() {
        given()
                .when().get("/api/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

    @Test
    void testHelloEndpoint4() {
        given()
                .when().get("/api/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

}