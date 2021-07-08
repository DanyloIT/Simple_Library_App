package com.example.simple_library_app.controller;

import com.example.simple_library_app.model.Author;
import com.example.simple_library_app.model.Book;
import com.example.simple_library_app.service.AuthorService;
import com.example.simple_library_app.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inject")
public class InjectDataController {
    private final BookService bookService;
    private final AuthorService authorService;

    public InjectDataController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String injectData() {
        Book effectiveJava = new Book();
        Author joshua = new Author();
        joshua.setName("Joshua");
        joshua.setLastName("Bloch");
        effectiveJava.setAuthors(List.of(joshua));
        effectiveJava.setTitle("Effective Java");
        effectiveJava.setDescription("Must read");
        bookService.save(effectiveJava);
        return "Done!";
    }
}
