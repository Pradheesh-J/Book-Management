package com.panimalar.book_management.controller;


import com.panimalar.book_management.dto.BookRequestDTO;
import com.panimalar.book_management.dto.BookResponseDTO;
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
//////////////Get books/////////////////////////
    @GetMapping("")
    public List<BookResponseDTO> getAllBooks(){
       return bookService.getAllBooks();
    }
/////////////Get book by ID////////////////////
    @GetMapping("/{id}")
    public BookResponseDTO getBook(@PathVariable("id") Integer id){
        return bookService.getBook(id);
    }
///////////////////Add book////////////////////
    @PostMapping("")
    public ResponseEntity<String> addBook(@RequestBody BookRequestDTO bookRequestDTO){
        bookService.addBook(bookRequestDTO);
        return new ResponseEntity<>("Added book", HttpStatus.CREATED);
    }
////////////////////Add books/////////////////
    @PostMapping("/bookList")
    public ResponseEntity<String> addBooks(@RequestBody List<BookRequestDTO> bookRequestDTOS){
        bookService.addBooks(bookRequestDTOS);
        return new ResponseEntity<>("added all books", HttpStatus.CREATED);
    }
///////////////////Delete books///////////////
    @DeleteMapping("")
    public ResponseEntity<String> deleteBooks(){
        bookService.deleteBooks();
        return new ResponseEntity<>("deleted all books", HttpStatus.OK);
    }
////////////////Delete book by ID/////////////
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("deleted book", HttpStatus.OK);
    }
}
