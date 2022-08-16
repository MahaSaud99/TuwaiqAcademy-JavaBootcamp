package com.example.schoolms.service;

import com.example.schoolms.exception.apiException;
import com.example.schoolms.model.Teacher;
import com.example.schoolms.repository.teacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class teacherService {
    teacherRepository teacherRepository;

    public teacherService(teacherRepository teacherRepository){
        this.teacherRepository=teacherRepository;
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(String id) {
        Teacher teacher=teacherRepository.findTeacherById(id);

        if(teacher==null){
            throw new apiException("Wrong teacher ID!");
        }
        teacherRepository.delete(teacher);
    }

    public void updateTeacher(String id, Teacher teacher) {
        Teacher teacher1= teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new apiException("Wrong teacher ID!");
        }
        teacher1.setName(teacher.getName());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }

    public Teacher getTeacherByID(String id) {
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new apiException("Wrong teacher ID!");
        }
        return teacher;
    }

    public List<Teacher> getTeachersBySalary(Integer salary) {
        List<Teacher> teachers= teacherRepository.findBySalaryGreaterThanEqual(salary);
        if (teachers.isEmpty()){
            throw new apiException("There is no teachers by this salary or grater than!");
        }
        return teachers;
    }
}
