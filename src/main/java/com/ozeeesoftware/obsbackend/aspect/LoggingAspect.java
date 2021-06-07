package com.ozeeesoftware.obsbackend.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozeeesoftware.obsbackend.model.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.StudentController.getAllStudents(..))")
    public void getAllStudentsPointcut(){

    }


    @Around("getAllStudentsPointcut()")
    public Object getAllStudentsLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();

        logger.info("method invoked"+className+" : "+methodName+"()");


        ResponseEntity<List<Student>> object= (ResponseEntity<List<Student>>) proceedingJoinPoint.proceed();

        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));

        logger.info("All students :"+mapper.writeValueAsString(object));

        return object;
    }

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.StudentController.getStudentById(..))")
    public void getStudentByIdPointcut(){

    }


    @Around("getStudentByIdPointcut()")
    public Object getStudentByIdLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();
        Object[] array=proceedingJoinPoint.getArgs();

        logger.info("method invoked"+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));

        ResponseEntity<Student> object= (ResponseEntity<Student>) proceedingJoinPoint.proceed();

        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));

        logger.info("Student found with id: " + object.getBody().getId() +":"+mapper.writeValueAsString(object));

        return object;
    }

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.StudentController.createStudent(..))")
    public void saveStudentPointcut(){

    }


    @Around("saveStudentPointcut()")
    public Object saveStudentLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();
        Object[] array=proceedingJoinPoint.getArgs();

        logger.info("method invoked"+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));

        ResponseEntity<Student> object= (ResponseEntity<Student>) proceedingJoinPoint.proceed();

        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));

        logger.info("Student successfully added :"+mapper.writeValueAsString(object));

        return object;
    }

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.StudentController.updateStudent(..))")
    public void updateStudentPointcut(){

    }


    @Around("updateStudentPointcut()")
    public Object updateStudentLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();
        Object[] array=proceedingJoinPoint.getArgs();



        logger.info("method invoked"+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));

        ResponseEntity<Student> object= (ResponseEntity<Student>) proceedingJoinPoint.proceed();



        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));



        logger.info("Student with id : "+object.getBody().getId()+" updated as : "+mapper.writeValueAsString(object));

        return object;
    }

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.StudentController.deleteStudentById(..))")
    public void deleteStudentByIdPointcut(){

    }


    @Around("deleteStudentByIdPointcut()")
    public Object deleteStudentByIdLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();
        Object[] array=proceedingJoinPoint.getArgs();


        logger.info("method invoked"+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));

        ResponseEntity<Student> object= (ResponseEntity<Student>) proceedingJoinPoint.proceed();



        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));



        logger.info("Student : "+mapper.writeValueAsString(object)+" deleted successfully");

        return object;
    }

}
