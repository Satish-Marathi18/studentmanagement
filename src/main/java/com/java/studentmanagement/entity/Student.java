package com.java.studentmanagement.entity;

import com.java.studentmanagement.dto.StudentRequestDTO;
import com.java.studentmanagement.dto.StudentResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private String usn;
    private String name;
    private int age;
    private String gender;
    private String contactNo;
    private String address;
    private String email;

    public Student(StudentRequestDTO studentRequestDTO) {
        this.usn = studentRequestDTO.getUsn();
        this.name = studentRequestDTO.getName();
        this.age = studentRequestDTO.getAge();
        this.gender = studentRequestDTO.getGender();
        this.contactNo = studentRequestDTO.getContactNo();
        this.address = studentRequestDTO.getAddress();
        this.email = studentRequestDTO.getEmail();
    }

}
