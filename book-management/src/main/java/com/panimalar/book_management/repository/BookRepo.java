package com.panimalar.book_management.repository;

import com.panimalar.book_management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String genre);
    List<Book> findByBookTitleContaining(String keyword);  // for partial matches

}
