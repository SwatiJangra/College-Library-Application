package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;
    private int authorAge;
    @Column(unique = true)
    private String authorEmail;
    @Column(unique = true)
    private String authorPhoneNumber;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> bookList=new ArrayList<>();
}
