package com.ozeeesoftware.obsbackend.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozeeesoftware.obsbackend.controller.StudentController;
import com.ozeeesoftware.obsbackend.model.Student;
import com.ozeeesoftware.obsbackend.repository.StudentRepository;
import com.ozeeesoftware.obsbackend.service.StudentServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentServiceImpl studentService;

    @MockBean
    private StudentRepository studentRepository;

    String url="/api/v1/students";

    @Test
    public void testGetAllStudents() throws Exception {

        List<Student> studentList=new ArrayList<Student>();
        studentList.add(new Student(1L,"John","Doe",100,100));
        studentList.add(new Student(2L,"John2","Doe2",90,90));

        when(studentService.getAllStudents()).thenReturn(new ResponseEntity<List<Student>>(studentList,HttpStatus.OK));

        MvcResult mvcResult=mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse=mvcResult.getResponse().getContentAsString();

        String expectedJsonResponse=objectMapper.writeValueAsString(studentList);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

    }

    @Test
    public void testGetStudentById() throws Exception {
        Student student=new Student(1L,"John","Doe",100,100);

        when(studentService.getStudentById(1L)).thenReturn(new ResponseEntity<Student>(student,HttpStatus.OK));

        MvcResult mvcResult= mockMvc.perform(get(url+"/"+1).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse=mvcResult.getResponse().getContentAsString();

        String expectedJsonResponse=objectMapper.writeValueAsString(student);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

    }

    @Test
    public void testCreateNewStudent() throws Exception {

        Student student=new Student(1L,"John","Doe",100,100);

        when(studentService.createStudent(student)).thenReturn(new ResponseEntity<Student>(student,HttpStatus.OK));

        mockMvc.perform(post(url+"/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andDo(print());


    }

    @Test
    public void testUpdateStudent() throws Exception {

        Student existingStudent=new Student(1L,"John","Doe",100,100);

        Student updatedStudent=new Student(1L,"John2","Doe2",100,100);

        when(studentService.createStudent(existingStudent)).thenReturn(new ResponseEntity<Student>(updatedStudent,HttpStatus.OK));

        mockMvc.perform(post(url+"/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(existingStudent)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeleteStudent() throws Exception {

        Student student=new Student(1L,"John","Doe",100,100);

        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        when(studentService.deleteStudent(student)).thenReturn(new ResponseEntity<>(response,HttpStatus.OK));

        mockMvc.perform(delete(url+"/delete")
                .content(objectMapper.writeValueAsString(student))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }







}
