package com.example.simple_library_app.service;

import com.example.simple_library_app.model.Author;
import com.example.simple_library_app.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);

    Book update(String title, String description, Author author, Long id);

    Optional<Book> getById(Long id);

    List<Book> getAll();
}
