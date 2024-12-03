package com.cocodeur.quarkus.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    private final List<Book> books;

    public BookRepository(
            @ConfigProperty(name = "books.genre", defaultValue = "Sci-fi") String genre
    ) {
        this.books = List.of(
                new Book(1, "Clean Code", "Robert C. Martin", 2008, genre),
                new Book(2, "The Pragmatic Programmer", "Andrew Hunt and David Thomas", 1999, genre),
                new Book(3, "Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 1994, genre),
                new Book(4, "Code Complete", "Steve McConnell", 1993, genre),
                new Book(5, "Refactoring", "Martin Fowler", 1999, genre),
                new Book(6, "Refactoring", "Martin Fowler", 1999, genre)
        );
    }

    public List<Book> getAllBooks() {
        return this.books;
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }


    public Optional<Book> getBookById(@PathParam("id") int id) {
        return getAllBooks().stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }
}
