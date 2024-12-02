package com.cocodeur.quarkus.rest;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Book {
    int id;
    String title;
    String author;
    int yearOfPublication;
    String genre;
}
