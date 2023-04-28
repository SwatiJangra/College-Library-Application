package com.example.demo.Controller;

import com.example.demo.RequestDTO.AuthorRequestDTO;
import com.example.demo.RequestDTO.AuthorUpdateRequestDTO;
import com.example.demo.ResponseDTO.AuthorResponseDTO;
import com.example.demo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public ResponseEntity<AuthorResponseDTO>  addAuthor(@RequestBody AuthorRequestDTO authorRequestDTO) {
        return new ResponseEntity<>(authorService.addAuthor(authorRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/get-author")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@RequestParam("id") int authorId) {
        return new ResponseEntity<>(authorService.getAuthorById(authorId), HttpStatus.FOUND);
    }

    @PutMapping("/update-author-details")
    public ResponseEntity<AuthorResponseDTO> updateAuthorDetails(@RequestBody AuthorUpdateRequestDTO authorUpdateRequestDTO) {
        return new ResponseEntity<>(authorService.updateAuthorDetails(authorUpdateRequestDTO), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-author")
    public ResponseEntity<String> deleteAuthor(@RequestParam("id") int authorId) {
        return new ResponseEntity<>(authorService.deleteAuthor(authorId), HttpStatus.GONE);
    }
}
