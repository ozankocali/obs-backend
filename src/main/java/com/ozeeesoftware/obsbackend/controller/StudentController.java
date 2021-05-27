package com.ozeeesoftware.obsbackend.controller;

import java.util.List;
import java.util.Map;

import com.ozeeesoftware.obsbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ozeeesoftware.obsbackend.model.Student;
import com.ozeeesoftware.obsbackend.service.StudentServiceImpl;



@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student studentDetails){
		return studentService.updateStudent(studentDetails);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String,Boolean>> deleteStudent(@RequestBody Student student){
		return studentService.deleteStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteStudentById(@PathVariable Long id){
		return studentService.deleteStudentById(id);
	}

}
