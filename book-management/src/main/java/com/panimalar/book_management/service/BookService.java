package com.panimalar.book_management.service;

import com.panimalar.book_management.dto.BookRequestDTO;
import com.panimalar.book_management.dto.BookResponseDTO;
import com.panimalar.book_management.mapper.BookMapper;
import com.panimalar.book_management.model.Book;
import com.panimalar.book_management.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
}
