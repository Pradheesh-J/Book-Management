package com.panimalar.book_management.service;

import com.panimalar.book_management.dto.BookRequestDTO;
import com.panimalar.book_management.dto.BookResponseDTO;
import com.panimalar.book_management.mapper.BookMapper;
import com.panimalar.book_management.model.Book;
import com.panimalar.book_management.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepo.findAll();
        return BookMapper.responseDTOList(books);
    }

    public BookResponseDTO getBook(Integer id) {
        Book book = bookRepo.findById(id).orElse(new Book());
        return BookMapper.booktoResponseDTO(book);

    }

    public void addBooks(List<BookRequestDTO> bookRequestDTOS) {
        List<Book> books = BookMapper.requestToBooks(bookRequestDTOS);
        bookRepo.saveAll(books);
    }

    public void addBook(BookRequestDTO bookRequestDTO) {
        Book book = BookMapper.requestToBook(bookRequestDTO);
        bookRepo.save(book);
    }


    public void deleteBooks() {
        bookRepo.deleteAll();
    }


    public void deleteBook(Integer id) {
        bookRepo.deleteById(id);
    }

    public ResponseEntity<String> updateBook(Integer id, BookRequestDTO bookRequestDTO) {
        Book book = BookMapper.requestToBook(bookRequestDTO);
       Optional<Book> book1 =  bookRepo.findById(id);
        if(book1.isEmpty()){
            bookRepo.save(book);
            return new ResponseEntity<>("New book created",HttpStatus.CREATED);
        } else{
            bookRepo.save(book);
            return new ResponseEntity<>("Book has been updated", HttpStatus.OK);
        }
    }

    public List<BookResponseDTO> getBookByAuthor(String author) {

        List<BookResponseDTO> bookResponseDTOS = BookMapper.responseDTOList(bookRepo.findByAuthor(author));
        return bookResponseDTOS;
    }
}
