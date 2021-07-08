package com.example.simple_library_app.service.impl;

import com.example.simple_library_app.dao.BookRepository;
import com.example.simple_library_app.model.Author;
import com.example.simple_library_app.model.Book;
import com.example.simple_library_app.service.BookService;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(String title, String description, Author author, Long id) {
        return bookRepository.update(title, description, author, id);
    }


    @Override
    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
