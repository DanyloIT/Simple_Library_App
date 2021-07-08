package com.example.simple_library_app.service;

import com.example.simple_library_app.model.Author;
import com.example.simple_library_app.model.Book;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);

    void update(String name, String lastName, Book book, Long id);

    Optional<Author> getById(Long id);

    List<Author> getAll();
}
