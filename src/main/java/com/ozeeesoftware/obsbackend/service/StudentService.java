package com.ozeeesoftware.obsbackend.service;

import com.ozeeesoftware.obsbackend.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface StudentService {
    ResponseEntity getAllStudents();
    ResponseEntity createStudent(Student student);
    ResponseEntity getStudentById(Long id);
    ResponseEntity updateStudent(Student studentDetails);
    ResponseEntity deleteStudent(Student student);
    ResponseEntity deleteStudentById(Long id);
}
