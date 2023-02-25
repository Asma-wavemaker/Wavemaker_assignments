package com.services;

import com.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents() ;
    Student create(Student student);
    Student getStudentById(int id);
    Student updateStudent(Student student);
    Student deleteStudentById(int id);
}
