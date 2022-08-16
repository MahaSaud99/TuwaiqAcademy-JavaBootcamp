package com.example.schoolms.service;

import com.example.schoolms.exception.apiException;
import com.example.schoolms.model.Student;
import com.example.schoolms.repository.studentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {
    studentRepository studentRepository;

    public studentService(studentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        Student student=studentRepository.findStudentById(id);

        if(student==null){
            throw new apiException("Wrong student ID!");
        }
        studentRepository.delete(student);
    }

    public void updateStudent(String id, Student student) {
       Student student1= studentRepository.findStudentById(id);
       if(student1==null){
           throw new apiException("Wrong student ID!");
       }
       student1.setName(student.getName());
       student1.setAge(student.getAge());
       student1.setMajor(student.getMajor());
       studentRepository.save(student1);
    }

    public Student getStudentByID(String id) {
        Student student=studentRepository.findStudentById(id);
        if(student==null){
            throw new apiException("Wrong student ID!");
        }
        return student;
    }

    public Student getStudentByName(String name) {
        Student student=studentRepository.findStudentByName(name);
        if(student==null){
            throw new apiException("Wrong student name!");
        }
        return student;
    }

    public List<Student> getStudentsByMajor(String major) {
        List<Student> students=studentRepository.findAllByMajor(major);
        if (students.isEmpty()){
            throw new apiException("There is no students by this major!");
        }
        return students;
    }

    public List<Student> getStudentsByAge(Integer age) {
        List<Student> students=studentRepository.findByAgeGreaterThanEqual(age);
        if (students.isEmpty()){
            throw new apiException("There is no students by this age or grater than!");
        }
        return students;
    }
}
