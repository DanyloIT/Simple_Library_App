package com.example.simple_library_app.service.impl;

import com.example.simple_library_app.dao.AuthorRepository;
import com.example.simple_library_app.model.Author;
import com.example.simple_library_app.model.Book;
import com.example.simple_library_app.service.AuthorService;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void update(String name, String lastName, Book book, Long id) {
        authorRepository.update(name, lastName, book, id);
    }


    @Override
    public Optional<Author> getById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
