package com.panimalar.book_management.mapper;

import com.panimalar.book_management.dto.BookRequestDTO;
import com.panimalar.book_management.dto.BookResponseDTO;
import com.panimalar.book_management.model.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    public static List<BookResponseDTO> responseDTOList(List<Book> books){
        LocalDateTime now = LocalDateTime.now();
        List<BookResponseDTO> responseDTOList = new ArrayList<>();
        for(Book book : books ){

            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setBookNo(book.getBookId());
            bookResponseDTO.setBookName(book.getBookTitle());
            bookResponseDTO.setWriter(book.getAuthor());
            bookResponseDTO.setPublisher(book.getPublisher());
            bookResponseDTO.setGenre(book.getCategory());
            bookResponseDTO.setCopy(book.getFormat());
            bookResponseDTO.setReleaseYear(book.getReleaseYear());
            bookResponseDTO.setTimeStamp(now);
            responseDTOList.add(bookResponseDTO);
        }
        return responseDTOList;
    }

    public static Book requestToBook(BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setBookId(bookRequestDTO.getBookNo());
        book.setBookTitle(bookRequestDTO.getBookName());
        book.setAuthor(bookRequestDTO.getWriter());
        book.setPublisher(bookRequestDTO.getPublisher());
        book.setCategory(bookRequestDTO.getGenre());
        book.setFormat(bookRequestDTO.getCopy());
        book.setReleaseYear(bookRequestDTO.getReleaseYear());
        return book;

    }

    public static BookResponseDTO booktoResponseDTO(Book book) {
        BookResponseDTO bookResponseDTO = new BookResponseDTO();
        bookResponseDTO.setBookNo(book.getBookId());
        bookResponseDTO.setBookName(book.getBookTitle());
        bookResponseDTO.setWriter(book.getAuthor());
        bookResponseDTO.setPublisher(book.getPublisher());
        bookResponseDTO.setGenre(book.getCategory());
        bookResponseDTO.setCopy(book.getFormat());
        bookResponseDTO.setReleaseYear(book.getReleaseYear());
        bookResponseDTO.setTimeStamp(LocalDateTime.now());
        return bookResponseDTO;
    }

    public static List<Book> requestToBooks(List<BookRequestDTO> bookRequestDTOS) {
        List<Book> books = new ArrayList<>();
        for(BookRequestDTO bookRequestDTO: bookRequestDTOS){
            Book book = new Book();
            book.setBookId(bookRequestDTO.getBookNo());
            book.setBookTitle(bookRequestDTO.getBookName());
            book.setAuthor(bookRequestDTO.getWriter());
            book.setPublisher(bookRequestDTO.getPublisher());
            book.setCategory(bookRequestDTO.getGenre());
            book.setFormat(bookRequestDTO.getCopy());
            book.setReleaseYear(bookRequestDTO.getReleaseYear());
            books.add(book);
        }
        return books;
    }
}
