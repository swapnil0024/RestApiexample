package com.example.RestApiexample.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RestApiexample.Repository.Book;
import com.example.RestApiexample.exception.BookNotFoundException;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {

        books.add(new Book(1, "Java", "James Gosling", 500,true));
        books.add(new Book(2, "Spring Boot", "Rod Johnson", 700,true));
        books.add(new Book(3, "Hibernate", "Gavin King", 600,true));
    }

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Get book by id
    public Book getBookById(int id) {

        return books.stream()
                .filter(b -> b.getBookId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found with id : " + id));
    }

    // Add book
    public Book addBook(Book book) {

        books.add(book);
        return book;
    }

    // Delete book
    public String deleteBook(int id) {

        Book book = getBookById(id);

        books.remove(book);

        return "Book Deleted Successfully";
    }

    public Book updateAvailability(int id, boolean avails) {

        Book book = books.stream()
                .filter(b -> b.getBookId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found with id : " + id));

        book.setAvailable(avails);
        return book;
    }
	

    public Book searchBookByTitle(String title) {

        return books.stream()
                .filter(b -> b.getBookName().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found with title : " + title));
    }

	public List<Book> getBooksByAuthor(String author) {
	    return books.stream()
	                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
	                .collect(Collectors.toList());
	}
}