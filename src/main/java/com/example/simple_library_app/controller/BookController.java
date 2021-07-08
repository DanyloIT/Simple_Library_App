package com.example.simple_library_app.controller;

import com.example.simple_library_app.model.Author;
import com.example.simple_library_app.model.Book;
import com.example.simple_library_app.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@RequestParam String title,
                         @RequestParam String description,
                         @RequestBody Author author, @PathVariable Long id) {
        return bookService.update(title, description, author, id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.getById(id).get();
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return bookService.getAll();
    }
}
