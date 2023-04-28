package com.example.demo.Service;

import com.example.demo.Entity.Author;
import com.example.demo.Repository.AuthorRepository;
import com.example.demo.RequestDTO.AuthorRequestDTO;
import com.example.demo.RequestDTO.AuthorUpdateRequestDTO;
import com.example.demo.ResponseDTO.AuthorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public AuthorResponseDTO addAuthor(AuthorRequestDTO authorRequestDTO) {
        Author author=new Author();
        author.setAuthorName(authorRequestDTO.getAuthorName());
        author.setAuthorAge(authorRequestDTO.getAuthorAge());
        author.setAuthorEmail(authorRequestDTO.getAuthorEmail());
        author.setAuthorPhoneNumber(authorRequestDTO.getAuthorPhoneNumber());

        authorRepository.save(author);

        AuthorResponseDTO authorResponseDTO=new AuthorResponseDTO();
        authorResponseDTO.setAuthorId(author.getAuthorId());
        authorResponseDTO.setAuthorName(author.getAuthorName());
        authorResponseDTO.setAuthorAge(author.getAuthorAge());
        authorResponseDTO.setAuthorEmail(author.getAuthorEmail());
        authorResponseDTO.setAuthorPhoneNumber(author.getAuthorPhoneNumber());

        return authorResponseDTO;
    }

    public AuthorResponseDTO getAuthorById(int authorId) {
        Author author=authorRepository.findById(authorId).get();

        AuthorResponseDTO authorResponseDTO=new AuthorResponseDTO();
        authorResponseDTO.setAuthorId(author.getAuthorId());
        authorResponseDTO.setAuthorName(author.getAuthorName());
        authorResponseDTO.setAuthorAge(author.getAuthorAge());
        authorResponseDTO.setAuthorEmail(author.getAuthorEmail());
        authorResponseDTO.setAuthorPhoneNumber(author.getAuthorPhoneNumber());

        return authorResponseDTO;
    }

    public AuthorResponseDTO updateAuthorDetails(AuthorUpdateRequestDTO authorUpdateRequestDTO) {
        Author author=authorRepository.findById(authorUpdateRequestDTO.getAuthorId()).get();
        author.setAuthorName(authorUpdateRequestDTO.getAuthorName());
        author.setAuthorAge(authorUpdateRequestDTO.getAuthorAge());
        author.setAuthorEmail(authorUpdateRequestDTO.getAuthorEmail());
        author.setAuthorPhoneNumber(authorUpdateRequestDTO.getAuthorPhoneNumber());

        Author updatedAuthor=authorRepository.save(author);

        AuthorResponseDTO authorResponseDTO=new AuthorResponseDTO();
        authorResponseDTO.setAuthorId(updatedAuthor.getAuthorId());
        authorResponseDTO.setAuthorName(updatedAuthor.getAuthorName());
        authorResponseDTO.setAuthorAge(updatedAuthor.getAuthorAge());
        authorResponseDTO.setAuthorEmail(updatedAuthor.getAuthorEmail());
        authorResponseDTO.setAuthorPhoneNumber(updatedAuthor.getAuthorPhoneNumber());

        return authorResponseDTO;
    }

    public String deleteAuthor(int authorId) {
        Author author=authorRepository.findById(authorId).get();
        authorRepository.delete(author);
        return "Author deleted successfully!";
    }
}
