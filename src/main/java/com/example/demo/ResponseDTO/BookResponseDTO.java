package com.example.demo.ResponseDTO;

import com.example.demo.Entity.Author;
import com.example.demo.Enum.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class BookResponseDTO {
    private int bookId;
    private String bookTitle;
    private String authorName;
    private int bookPrice;
    private boolean bookIsIssued;
    private Genre genre;
}
