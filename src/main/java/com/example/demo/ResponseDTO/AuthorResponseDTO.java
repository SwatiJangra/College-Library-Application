package com.example.demo.ResponseDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@NoArgsConstructor
@Data
public class AuthorResponseDTO {
    private int authorId;
    private String authorName;
    private int authorAge;
    private String authorEmail;
    private String authorPhoneNumber;
}
