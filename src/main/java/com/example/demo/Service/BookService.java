package com.example.demo.Service;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import com.example.demo.Repository.AuthorRepository;
import com.example.demo.Repository.BookRepository;
import com.example.demo.RequestDTO.BookRequestDTO;
import com.example.demo.RequestDTO.BookUpdateRequestDTO;
import com.example.demo.ResponseDTO.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public BookResponseDTO addBook(BookRequestDTO bookRequestDTO) {
        Author author=authorRepository.findById(bookRequestDTO.getAuthorId()).get();
        Book book=new Book();
        book.setBookTitle(bookRequestDTO.getBookTitle());
        book.setBookPrice(bookRequestDTO.getBookPrice());
        book.setBookIsIssued(false);// initially book is not issued to anyone
        book.setGenre(bookRequestDTO.getGenre());
        book.setAuthor(author);

        // adding book in the book-list related to the author
        author.getBookList().add(book);
        authorRepository.save(author);

        BookResponseDTO bookResponseDTO=new BookResponseDTO();
        bookResponseDTO.setBookId(book.getBookId());
        bookResponseDTO.setBookTitle(book.getBookTitle());
        bookResponseDTO.setAuthorName(book.getAuthor().getAuthorName());
        bookResponseDTO.setBookPrice(book.getBookPrice());
        bookResponseDTO.setGenre(book.getGenre());
        bookResponseDTO.setBookIsIssued(book.isBookIsIssued());


        return bookResponseDTO;
    }
    public BookResponseDTO getBookById(int bookId) {
        Book book=bookRepository.findById(bookId).get();


        BookResponseDTO bookResponseDTO=new BookResponseDTO();
        bookResponseDTO.setBookId(book.getBookId());
        bookResponseDTO.setBookTitle(book.getBookTitle());
        bookResponseDTO.setAuthorName(book.getAuthor().getAuthorName());
        bookResponseDTO.setBookPrice(book.getBookPrice());
        bookResponseDTO.setGenre(book.getGenre());
        bookResponseDTO.setBookIsIssued(book.isBookIsIssued());


        return bookResponseDTO;
    }
    public BookResponseDTO updateBookDetails(BookUpdateRequestDTO bookUpdateRequestDTO) {
        Book book=bookRepository.findById(bookUpdateRequestDTO.getAuthorId()).get();
        book.setBookTitle(bookUpdateRequestDTO.getBookTitle());
        book.setBookPrice(bookUpdateRequestDTO.getBookPrice());
        book.setGenre(bookUpdateRequestDTO.getGenre());
        book.setBookIsIssued(bookUpdateRequestDTO.isBookIsIssued());
        Author author=bookRepository.findById(bookUpdateRequestDTO.getAuthorId()).get().getAuthor();
        book.setAuthor(author);

        authorRepository.save(author);
        bookRepository.save(book);

        BookResponseDTO bookResponseDTO=new BookResponseDTO();
        bookResponseDTO.setBookId(book.getBookId());
        bookResponseDTO.setBookTitle(book.getBookTitle());
        bookResponseDTO.setAuthorName(book.getAuthor().getAuthorName());
        bookResponseDTO.setBookPrice(book.getBookPrice());
        bookResponseDTO.setGenre(book.getGenre());
        bookResponseDTO.setBookIsIssued(book.isBookIsIssued());


        return bookResponseDTO;
    }
}
