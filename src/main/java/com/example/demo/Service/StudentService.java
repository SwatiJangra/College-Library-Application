package com.example.demo.Service;

import com.example.demo.Entity.LibraryCard;
import com.example.demo.Entity.Student;
import com.example.demo.Enum.LibraryCardStatus;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.RequestDTO.StudentRequestDTO;
import com.example.demo.RequestDTO.StudentUpdateRequestDTO;
import com.example.demo.ResponseDTO.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO) {
        // creating a new student
        Student student=new Student();
        // getting values from user and setting to the created student
        student.setStudentName(studentRequestDTO.getStudentName());
        student.setStudentAge(studentRequestDTO.getStudentAge());
        student.setStudentEmail(studentRequestDTO.getStudentEmail());
        student.setStudentPhoneNumber(studentRequestDTO.getStudentPhoneNumber());
        student.setDepartment(studentRequestDTO.getDepartment());

        //creating library card
        LibraryCard libraryCard=new LibraryCard();
        // connecting student details with library card
        libraryCard.setLibraryCardStatus(LibraryCardStatus.ACTIVATED);
        // linking card to student
        libraryCard.setStudent(student);
        // adding library card in student's details
        student.setLibraryCard(libraryCard);
        // save student details in db
        studentRepository.save(student);

        // Creating Response Object of student
        StudentResponseDTO studentResponseDTO=new StudentResponseDTO();
        studentResponseDTO.setStudentId(student.getStudentId());
        studentResponseDTO.setStudentName(student.getStudentName());
        studentResponseDTO.setStudentAge(student.getStudentAge());
        studentResponseDTO.setStudentEmail(student.getStudentEmail());
        studentResponseDTO.setStudentPhoneNumber(student.getStudentPhoneNumber());
        studentResponseDTO.setDepartment(student.getDepartment());

        return studentResponseDTO;
    }

    public StudentResponseDTO getStudentById(int studentId) {
        Student student=studentRepository.findById(studentId).get();

        // Creating Response Object of student
        StudentResponseDTO studentResponseDTO=new StudentResponseDTO();
        studentResponseDTO.setStudentId(student.getStudentId());
        studentResponseDTO.setStudentName(student.getStudentName());
        studentResponseDTO.setStudentAge(student.getStudentAge());
        studentResponseDTO.setStudentEmail(student.getStudentEmail());
        studentResponseDTO.setStudentPhoneNumber(student.getStudentPhoneNumber());
        studentResponseDTO.setDepartment(student.getDepartment());

        return studentResponseDTO;
    }

    public StudentResponseDTO getStudentByEmail(String studentEmail) throws Exception {
        Student student;
        StudentResponseDTO studentResponseDTO=new StudentResponseDTO();
        try {
            student=studentRepository.findByStudentEmail(studentEmail);
            // setting values for response object
            studentResponseDTO.setStudentId(student.getStudentId());
            studentResponseDTO.setStudentName(student.getStudentName());
            studentResponseDTO.setStudentAge(student.getStudentAge());
            studentResponseDTO.setStudentEmail(student.getStudentEmail());
            studentResponseDTO.setStudentPhoneNumber(student.getStudentPhoneNumber());
            studentResponseDTO.setDepartment(student.getDepartment());
        } catch(Exception e) {
            throw new Exception("Student not found----> " + e.getMessage());
        }

        return studentResponseDTO;
    }

    public StudentResponseDTO updateDetailsOfStudent(StudentUpdateRequestDTO studentUpdateRequestDTO) {
        Student student=studentRepository.findById(studentUpdateRequestDTO.getStudentId()).get();
        // setting updated values;
        student.setStudentName(studentUpdateRequestDTO.getStudentName());
        student.setStudentAge(studentUpdateRequestDTO.getStudentAge());
        student.setStudentEmail(studentUpdateRequestDTO.getStudentEmail());
        student.setStudentPhoneNumber(studentUpdateRequestDTO.getStudentPhoneNumber());
        student.setDepartment(studentUpdateRequestDTO.getDepartment());

        // create a new student and save details
        Student updatedStudent=studentRepository.save(student);

        // Creating Response Object of student
        StudentResponseDTO studentResponseDTO=new StudentResponseDTO();
        studentResponseDTO.setStudentId(student.getStudentId());
        studentResponseDTO.setStudentName(student.getStudentName());
        studentResponseDTO.setStudentAge(student.getStudentAge());
        studentResponseDTO.setStudentEmail(student.getStudentEmail());
        studentResponseDTO.setStudentPhoneNumber(student.getStudentPhoneNumber());
        studentResponseDTO.setDepartment(student.getDepartment());

        return studentResponseDTO;
    }

    public String deleteStudent(int id) {
        Student student=studentRepository.findById(id).get();
        studentRepository.delete(student);

        return "student has been successfully deleted";

    }
}
