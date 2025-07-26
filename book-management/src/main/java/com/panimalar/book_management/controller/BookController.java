package com.panimalar.book_management.controller;


import com.panimalar.book_management.dto.BookRequestDTO;
import com.panimalar.book_management.dto.BookResponseDTO;
import com.panimalar.book_management.model.Book;
import com.panimalar.book_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("")
    public List<BookResponseDTO> getAllBooks(){
       return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public BookResponseDTO getBook(@PathVariable("id") Integer id){
        return bookService.getBook(id);
    }
    @PostMapping("")
    public ResponseEntity<String> addBook(@RequestBody BookRequestDTO bookRequestDTO){
        bookService.addBook(bookRequestDTO);
        return new ResponseEntity<>("Added book", HttpStatus.CREATED);
    }
}
