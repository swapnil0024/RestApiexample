package com.example.RestApiexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApiexample.Repository.Book;
import com.example.RestApiexample.service.BookService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/books")
public class BookController {
	
    private final BookService service;

   public  BookController(BookService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    // GET BY ID
//    @GetMapping("/{id}")
    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return service.getBookById(id);
    }
    
    @GetMapping(value = "/search", params = "title")
    public Book searchBookByTitle(@Valid @RequestParam String title) {
        return service.searchBookByTitle(title);
    }
    //we have mapped "/serach" for two functions to avoid ambiguity we desribed value and params (Ambiguous mapping)
    @GetMapping(value = "/search", params = "author")
    public List<Book> getBooksByAuthor(@Valid @RequestParam String author) {
        return service.getBooksByAuthor(author);
    }
    
    @PutMapping("/UpdateBookAvails")
    public Book updateBookavail(@RequestParam int id,@RequestParam boolean avail) {
    	return service.updateAvailability(id, avail);
    }

   // ADD BOOK
  @PostMapping("/save")
    public Book addBook(@Valid @RequestBody Book book) {
        return service.addBook(book);
    }

//    // DELETE BOOK
    @DeleteMapping("/{id}")
    public String deleteBook(@Valid @PathVariable int id) {
        return service.deleteBook(id);
    }
    
    
}