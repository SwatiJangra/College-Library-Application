package com.example.demo.Entity;

import com.example.demo.Enum.LibraryCardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libraryCardNumber;
    @Enumerated(EnumType.STRING)
    private LibraryCardStatus libraryCardStatus;
    @CreationTimestamp
    private Date createdOn;
    @OneToOne
    @JoinColumn
    private Student student;
}
