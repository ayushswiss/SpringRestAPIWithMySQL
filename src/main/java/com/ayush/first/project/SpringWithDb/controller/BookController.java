package com.ayush.first.project.SpringWithDb.controller;

import com.ayush.first.project.SpringWithDb.model.Book;
import com.ayush.first.project.SpringWithDb.repository.BookManagement;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookManagement bookManagement;

    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Book book) {
        bookManagement.save(book);
        return "Book saved successfully";
    }

    @PostMapping("/saveBooks")
    public String saveBooks(@RequestBody List<Book> books) {
        bookManagement.saveAll(books);
        return "Book saved successfully";
    }
    
    @GetMapping("/getBooks")
    public List<Book> getAllBooks() {
        return bookManagement.findAll();
    }
    
    @GetMapping("/getBook/{id}")
    public Optional<Book> getBook(@PathVariable("id") Long id) {
        return bookManagement.findById(id);
        
    }
    
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
         bookManagement.deleteById(id);
         return "Book deleted successfully";        
    }
}
