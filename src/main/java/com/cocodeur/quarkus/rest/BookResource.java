package com.cocodeur.quarkus.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
public class BookResource {
    @Inject
    Logger logger;
    @Inject
    private BookRepository bookRepository;

    @GET

    public List<Book> getAllBooks() {
        logger.info("Getting all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        logger.info("Counting all books");
        return bookRepository.countAllBooks();
    }


    @GET
    @Path("/{id}")
    public Optional<Book> getBookById(@PathParam("id") int id) {
        logger.info("Getting a book by id: " + id);
        return bookRepository.getBookById(id);
    }
}
