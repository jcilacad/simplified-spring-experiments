package com.projects.cachingdata.repository;

import com.projects.cachingdata.entity.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);
}
