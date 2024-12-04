package com.cocodeur.quarkus.rest;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
public class BookResourceIT extends BooksResourceTest {
    @Override
    protected String getExpectedGenre() {
        return "Sci-fi";
    }
}
