package com.ozeeesoftware.obsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozeeesoftware.obsbackend.model.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}
