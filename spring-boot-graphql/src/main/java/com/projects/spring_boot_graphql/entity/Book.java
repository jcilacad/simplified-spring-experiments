package com.projects.spring_boot_graphql.entity;

import java.util.Arrays;
import java.util.List;

public record Book(String id, String name, int pageCount, String authorId) {

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "Effective Java", 416, "author-1"),
            new Book("book-2", "Effective Spring boot", 799, "author-2")
    );

    public static Book getById(String id) {
        return books.stream()
                .filter(b -> b.id.equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}
