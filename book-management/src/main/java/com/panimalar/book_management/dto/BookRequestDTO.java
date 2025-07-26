package com.panimalar.book_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {
    private int bookNo;
    private String bookName;
    private String writer;
    private String publisher;
    private String genre;
    private String copy;
    private String releaseYear;
}
