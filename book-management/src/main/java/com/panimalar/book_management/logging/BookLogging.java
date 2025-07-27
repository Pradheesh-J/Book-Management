package com.panimalar.book_management.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookLogging {
    @Before("execution(* com.panimalar.book_management.controller.BookController.*(..))")
    public void fetchLog(){
        System.out.println("API called");
    }
    @Before("execution(* com.panimalar.book_management.controller.BookController.getAllBooks())")
    public void getAllBooksLog(){
        System.out.println("Fetching all books from database");
    }

    @Before("execution(* com.panimalar.book_management.controller.BookController.getBook(*))")
    public void getBookByIdLog(){
        System.out.println("Fetching book by ID from database");
    }

    @Before("execution(* com.panimalar.book_management.controller.BookController.addBook(*))")
    public void addBookLog(){
        System.out.println("Adding a new book to database");
    }

    @Before("execution(* com.panimalar.book_management.controller.BookController.addBooks(*))")
    public void addBooksLog(){
        System.out.println("Adding multiple books to database");
    }

    @Before("execution(* com.panimalar.book_management.controller.BookController.deleteBooks())")
    public void deleteBooksLog(){
        System.out.println("Deleting all books from database");
    }

    @Before("execution(* com.panimalar.book_management.controller.BookController.deleteBook(*))")
    public void deleteBookByIdLog(){
        System.out.println("Deleting book by ID from database");
    }

    @Before("execution(* com.panimalar.book_management.controller.BookController.updateBook(*,*))")
    public void updateBookLog(){
        System.out.println("Updating book details in database");
    }
    @Before("execution(* com.panimalar.book_management.controller.BookController.getBookByAuthor(*))")
    public void getBookByAuthorLog(){
        System.out.println("Fetching Book by Author name");
    }
}
