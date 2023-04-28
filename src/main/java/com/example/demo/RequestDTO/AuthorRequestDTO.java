package com.example.demo.RequestDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@Data
public class AuthorRequestDTO {
    private String authorName;
    private int authorAge;
    private String authorEmail;
    private String authorPhoneNumber;
}
