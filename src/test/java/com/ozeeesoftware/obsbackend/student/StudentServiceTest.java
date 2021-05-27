package com.ozeeesoftware.obsbackend.student;

import com.ozeeesoftware.obsbackend.model.Student;
import com.ozeeesoftware.obsbackend.repository.StudentRepository;
import com.ozeeesoftware.obsbackend.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @MockBean
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void testGetAllStudents(){
        List<Student> studentList=new ArrayList<Student>();
        studentList.add(new Student(1,"John","Doe",100,100));
        studentList.add(new Student(2,"John2","Doe2",90,90));

        when(studentRepository.findAll()).thenReturn(studentList);

        assertEquals(2,studentService.getAllStudents().getBody().size());



    }

    @Test
    public void testGetStudentById(){
        Student student=new Student(1,"John","Doe",100,100);

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        assertEquals(student,studentService.getStudentById(1L).getBody());
    }




    @Test
    public void testCreateNewStudent(){
        Student student=new Student(1,"John","Doe",100,100);

        when(studentRepository.save(student)).thenReturn(student);

        assertEquals(student,studentService.createStudent(student).getBody());


    }



    @Test()
    public void testDeleteUser(){
        Student student=new Student(1,"John","Doe",100,100);

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        studentService.deleteStudent(student);

        verify(studentRepository,times(1)).delete(student);

    }


}
