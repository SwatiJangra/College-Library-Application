package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.RequestDTO.StudentRequestDTO;
import com.example.demo.RequestDTO.StudentUpdateRequestDTO;
import com.example.demo.ResponseDTO.StudentResponseDTO;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<StudentResponseDTO> addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return new ResponseEntity<>(studentService.addStudent(studentRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get-student-by-id")
    public ResponseEntity<StudentResponseDTO> getStudentById(@RequestParam("id") int studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.FOUND);
    }

    @GetMapping("/get-student-by-email")
    public ResponseEntity<StudentResponseDTO> getStudentByEmail(@RequestParam("email") String studentEmail) throws Exception {
        return new ResponseEntity<>(studentService.getStudentByEmail(studentEmail), HttpStatus.FOUND);
    }

    @PutMapping("/update-details")
    public ResponseEntity<StudentResponseDTO> updateDetailsOfStudent(@RequestBody StudentUpdateRequestDTO studentUpdateRequestDTO) {
        return new ResponseEntity<>(studentService.updateDetailsOfStudent(studentUpdateRequestDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") int id) {
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.GONE);
    }
}
