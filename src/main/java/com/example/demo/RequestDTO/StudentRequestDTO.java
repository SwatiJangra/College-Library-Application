package com.example.demo.RequestDTO;

import com.example.demo.Enum.Department;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentRequestDTO {
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String studentPhoneNumber;
    private Department department;
}
