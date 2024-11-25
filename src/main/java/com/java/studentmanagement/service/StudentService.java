package com.java.studentmanagement.service;

import com.java.studentmanagement.dto.StudentRequestDTO;
import com.java.studentmanagement.dto.StudentResponseDTO;
import com.java.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {
    StudentRequestDTO addStudent(StudentRequestDTO studentRequestDTO);

    List<StudentResponseDTO> getAllStudent();

    StudentResponseDTO getStudentById(String usn);

    StudentRequestDTO updateStudent(StudentRequestDTO studentRequestDTO);

    void deleteStudent(String usn);
}
