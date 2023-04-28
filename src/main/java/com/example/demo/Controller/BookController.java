package com.example.demo.Controller;

import com.example.demo.RequestDTO.BookRequestDTO;
import com.example.demo.RequestDTO.BookUpdateRequestDTO;
import com.example.demo.ResponseDTO.BookResponseDTO;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity<BookResponseDTO> addBook(@RequestBody BookRequestDTO bookRequestDTO) {
        return new ResponseEntity<>(bookService.addBook(bookRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/find-book-by-bookId")
    public ResponseEntity<BookResponseDTO> getBookByBookId(@RequestParam("id") int bookId) {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.FOUND);
    }
    @PutMapping("/update-book-details")
    public ResponseEntity<BookResponseDTO> updateBookDetails(@RequestBody BookUpdateRequestDTO bookUpdateRequestDTO) {
        return new ResponseEntity<>(bookService.updateBookDetails(bookUpdateRequestDTO), HttpStatus.ACCEPTED);
    }
}
