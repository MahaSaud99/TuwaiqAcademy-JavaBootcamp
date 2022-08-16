package com.example.schoolms.repository;

import com.example.schoolms.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface teacherRepository extends JpaRepository<Teacher,String> {
    Teacher findTeacherById(String id);
    List<Teacher> findBySalaryGreaterThanEqual(Integer salary);
}
