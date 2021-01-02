package com.ozeeesoftware.obsbackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ozeeesoftware.obsbackend.exception.NotFoundByIdException;
import com.ozeeesoftware.obsbackend.model.Student;
import com.ozeeesoftware.obsbackend.repository.StudentRepository;









@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student student) {
		
		int gpaCalculation=(int)((student.getFinalExam()*0.7)+((student.getMidTermExam()*0.3)));
		student.setGradePointAverage(gpaCalculation);
		return studentRepository.save(student);
	}
	
	public ResponseEntity<Student> getStudentById(Long id) {
		Student student =studentRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Student not exist with id:"+id));
		return ResponseEntity.ok(student);
	}
	
	public ResponseEntity<Student> updateStudent(Student studentDetails){
		Student student =studentRepository.findById(studentDetails.getId()).orElseThrow(()->new NotFoundByIdException("Student not exist with id:"+studentDetails.getId()));
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setMidTermExam(studentDetails.getMidTermExam());
		student.setFinalExam(studentDetails.getFinalExam());
		int gpaCalculation=(int)((studentDetails.getFinalExam()*0.7)+((studentDetails.getMidTermExam()*0.3)));
		student.setGradePointAverage(gpaCalculation);

		Student updatedStudent=studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	public ResponseEntity<Map<String,Boolean>> deleteStudent(Student student){
		Student existingStudent =studentRepository.findById(student.getId()).orElseThrow(()->new NotFoundByIdException("Student not exist with id:"+student.getId()));
		studentRepository.delete(existingStudent);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	public ResponseEntity<Map<String,Boolean>> deleteStudentById(Long id){
		Student student =studentRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Student not exist with :"+id));
		studentRepository.delete(student);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
