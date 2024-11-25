package com.java.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
    private String usn;
    private String name;
    private int age;
    private String gender;
    private String contactNo;
    private String address;
    private String email;
}
