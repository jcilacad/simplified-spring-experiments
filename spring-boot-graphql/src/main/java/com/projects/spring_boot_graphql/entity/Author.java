package com.projects.spring_boot_graphql.entity;

import java.util.Arrays;
import java.util.List;

public record Author(String id, String firstName, String lastName) {

    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "first name 1", "last name 1"),
            new Author("author-2", "first name 2", "last name 2")
    );

    public static Author getById(String id) {
        return authors.stream()
                .filter(author -> author.id.equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}
