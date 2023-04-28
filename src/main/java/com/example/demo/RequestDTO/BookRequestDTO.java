package com.example.demo.RequestDTO;

import com.example.demo.Enum.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookRequestDTO {
    private String bookTitle;
    private int authorId;
    private int bookPrice;
    private Genre genre;
    private boolean bookIsIssued;

}
