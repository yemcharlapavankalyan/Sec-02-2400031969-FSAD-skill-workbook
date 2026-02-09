package com.klu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

@RestController
public class LibraryController {

    List<Book> books = new ArrayList<>();

    // 1 welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System";
    }

    // 2 count
    @GetMapping("/count")
    public int countBooks() {
        return 100;
    }

    // 3 price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 4 list of books
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java Programming", "Spring Boot Guide", "Hibernate Basics");
    }

    // 5 book by id
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    // 6 search
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // 7 author
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // 8 add book
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added successfully";
    }

    // 9 view books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return books;
    }
}