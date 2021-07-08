package com.example.simple_library_app.dao;

import com.example.simple_library_app.model.Author;
import com.example.simple_library_app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Modifying
    @Query("UPDATE Author a SET a.name = :name, a.lastName = :lastName, a.books = :book WHERE a.id = :id")
    void update(@Param("name") String name,
                  @Param("lastName") String lastName,
                  @Param("book") Book book,
                  @Param("id") Long id);
}
