package com.example.simple_library_app.service.impl;

import com.example.simple_library_app.dao.AuthorRepository;
import com.example.simple_library_app.dao.BookRepository;
import com.example.simple_library_app.model.Author;
import com.example.simple_library_app.model.Book;
import com.example.simple_library_app.service.AuthorService;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

    @Override
    public List<Author> getAllBookContains(String title) {
        List<Book> bookList = bookRepository.findAllByTitleContains(title);
        List<Author> authorList = bookList.stream()
                .map(Book::getAuthors)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return authorList;
    }
}
