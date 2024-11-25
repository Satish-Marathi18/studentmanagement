package com.java.studentmanagement.controller;

import com.java.studentmanagement.dto.StudentRequestDTO;
import com.java.studentmanagement.dto.StudentResponseDTO;
import com.java.studentmanagement.entity.Student;
import com.java.studentmanagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {


    StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public StudentRequestDTO addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return studentService.addStudent(studentRequestDTO);
    }

    @GetMapping("/get")
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/getByUsn/{usn}")
    public StudentResponseDTO getStudentById(@PathVariable String usn) {
        return studentService.getStudentById(usn);
    }

    @PutMapping("/put")
    public StudentRequestDTO updateStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return studentService.updateStudent(studentRequestDTO);
    }

    @DeleteMapping("/delete/{usn}")
    public void deleteStudentById(@PathVariable String usn) {
        studentService.deleteStudent(usn);
    }
}
