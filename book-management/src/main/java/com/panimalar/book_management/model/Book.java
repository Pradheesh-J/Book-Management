package com.panimalar.book_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    private int bookId;
    private String bookTitle;
    private String author;
    private String publisher;
    private String category;
    private String format;
    private String releaseYear;

}
