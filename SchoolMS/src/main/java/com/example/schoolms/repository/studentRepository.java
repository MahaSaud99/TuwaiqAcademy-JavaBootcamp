package com.example.schoolms.repository;

import com.example.schoolms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface studentRepository extends JpaRepository<Student,String> {
    Student findStudentById(String id);
    Student findStudentByName(String name);
    List<Student> findAllByMajor(String major);

    List<Student> findByAgeGreaterThanEqual(Integer age);
}
