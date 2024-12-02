package com.cocodeur.quarkus.rest;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BooksResourceTest {
    @Test
    void shouldGetAllBooks() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .when()
                .get("/api/books")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("size()", is(6));
    }

    @Test
    void shouldCountAllBooks() {
        given()
                .header(ACCEPT, TEXT_PLAIN)
                .when()
                .get("/api/books/count")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body(is("6"));
    }

    @Test
    void shouldGetBookById() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/api/books/{id}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("title", is("Clean Code"))
                .body("author", is("Robert C. Martin"))
                .body("yearOfPublication", is(2008))
                .body("genre", is("IT"))
        ;
    }

}
