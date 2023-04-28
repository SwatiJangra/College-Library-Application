package com.example.demo.Entity;

import com.example.demo.Enum.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private int studentAge;
    @Column(unique = true)
    private String studentEmail;
    @Column(unique = true)
    private String studentPhoneNumber;
    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private LibraryCard libraryCard;

}
