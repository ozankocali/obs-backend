package com.ozeeesoftware.obsbackend.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozeeesoftware.obsbackend.model.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.getAllStudents(..))")
    public void getAllStudentsPointcut(){

    }


    @Around("getAllStudentsPointcut()")
    public Object getAllStudentsLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();

        logger.info("method invoked"+className+" : "+methodName+"()");


        List<Student> object=(List<Student>) proceedingJoinPoint.proceed();

        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));

        logger.info("All students :"+mapper.writeValueAsString(object));

        return object;
    }

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.getStudentById(..))")
    public void getStudentByIdPointcut(){

    }


    @Around("getStudentByIdPointcut()")
    public Object getStudentByIdLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();
        Object[] array=proceedingJoinPoint.getArgs();

        logger.info("method invoked"+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));

        Student object=(Student)proceedingJoinPoint.proceed();

        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));

        logger.info("Student found with id: " + object.getId() +":"+mapper.writeValueAsString(object));

        return object;
    }

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.createStudent(..))")
    public void saveStudentPointcut(){

    }


    @Around("saveStudentPointcut()")
    public Object saveStudentLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();
        Object[] array=proceedingJoinPoint.getArgs();

        logger.info("method invoked"+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));

        Student object=(Student) proceedingJoinPoint.proceed();

        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));

        logger.info("Student successfully added :"+mapper.writeValueAsString(object));

        return object;
    }

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.updateStudent(..))")
    public void updateStudentPointcut(){

    }


    @Around("updateStudentPointcut()")
    public Object updateStudentLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();
        Object[] array=proceedingJoinPoint.getArgs();



        logger.info("method invoked"+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));

        Student object=(Student) proceedingJoinPoint.proceed();



        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));



        logger.info("Student with id : "+object.getId()+" updated as : "+mapper.writeValueAsString(object));

        return object;
    }

    @Pointcut(value = "execution(* com.ozeeesoftware.obsbackend.controller.deleteStudentById(..))")
    public void deleteStudentByIdPointcut(){

    }


    @Around("deleteStudentByIdPointcut()")
    public Object deleteStudentByIdLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();
        Object[] array=proceedingJoinPoint.getArgs();


        logger.info("method invoked"+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));

        Student object=(Student) proceedingJoinPoint.proceed();



        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));



        logger.info("Student : "+mapper.writeValueAsString(object)+" deleted successfully");

        return object;
    }

}
