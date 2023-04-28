package com.example.demo.RequestDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorUpdateRequestDTO {
    private int authorId;
    private String authorName;
    private int authorAge;
    private String authorEmail;
    private String authorPhoneNumber;
}
