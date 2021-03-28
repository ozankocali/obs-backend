package com.ozeeesoftware.obsbackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozeeesoftware.obsbackend.model.Student;
import com.ozeeesoftware.obsbackend.service.StudentServiceImpl;



@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/students/save")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PutMapping("/students/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student studentDetails){
		return studentService.updateStudent(studentDetails);
	}
	@DeleteMapping("/students/delete")
	public ResponseEntity<Map<String,Boolean>> deleteStudent(@RequestBody Student student){
		return studentService.deleteStudent(student);
	}
	
	@DeleteMapping("/students/delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteStudentById(@PathVariable Long id){
		return studentService.deleteStudentById(id);
	}

}
