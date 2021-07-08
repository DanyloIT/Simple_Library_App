package com.example.simple_library_app.dao;

import com.example.simple_library_app.model.Author;
import com.example.simple_library_app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Query("UPDATE Book b SET b.title = :title, b.description = :description, b.authors = :author WHERE b.id = :id")
    Book update(@Param("title") String title, @Param("description") String description,
                @Param("author")Author author, @Param("id") Long id);

    List<Book> findAllByTitleContains(String title);
}
