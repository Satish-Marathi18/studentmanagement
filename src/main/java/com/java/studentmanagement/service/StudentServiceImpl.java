package com.java.studentmanagement.service;

import com.java.studentmanagement.dto.StudentRequestDTO;
import com.java.studentmanagement.dto.StudentResponseDTO;
import com.java.studentmanagement.entity.Student;
import com.java.studentmanagement.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentRequestDTO addStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student(studentRequestDTO);
        if(studentRepository.existsById(student.getUsn())) {
            log.info("Student already exists");
            throw new IllegalArgumentException("Student already exists "+student.getUsn());
        }
            studentRepository.save(student);
            return studentRequestDTO;
        }

    @Override
    public List<StudentResponseDTO> getAllStudent() {
       return mapToDTOList(studentRepository.findAll());
    }

    @Override
    public StudentResponseDTO getStudentById(String usn) {
        return mapToDTO(studentRepository.findById(usn).orElseThrow(() -> new IllegalArgumentException("Student not found")));
    }

    @Override
    public StudentRequestDTO updateStudent(StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.findById(studentRequestDTO.getUsn()).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setAddress(studentRequestDTO.getAddress());
        student.setContactNo(studentRequestDTO.getContactNo());
        student.setGender(studentRequestDTO.getGender());
        student.setAge(studentRequestDTO.getAge());
        studentRepository.save(student);
        return studentRequestDTO;
    }

    @Override
    public void deleteStudent(String usn) {
        Student student = studentRepository.findById(usn).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        if(studentRepository.existsById(usn)) {
            studentRepository.deleteById(usn);
        }
    }

    public List<StudentResponseDTO> mapToDTOList(List<Student> students) {
        return students.stream().map((student) ->new StudentResponseDTO(student.getUsn(),student.getName(),student.getAge(),student.getGender(),student.getAddress())).toList();
    }

    public StudentResponseDTO mapToDTO(Student student) {
        return new StudentResponseDTO(student.getUsn(), student.getName(), student.getAge(), student.getGender(), student.getAddress());
    }


}

