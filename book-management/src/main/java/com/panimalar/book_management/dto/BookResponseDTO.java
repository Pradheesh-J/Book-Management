package com.panimalar.book_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
    private int bookNo;
    private String bookName;
    private String writer;
    private String publisher;
    private String genre;
    private String copy;
    private String releaseYear;
    private LocalDateTime timeStamp;
}
