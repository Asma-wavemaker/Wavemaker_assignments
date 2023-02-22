package com.controller;
import com.model.Student;
import com.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @GetMapping
    public List<Student> getStudents(){
        logger.info("Students list");
        return studentService.getStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        logger.info("create Student is invoked {}",student);
        return studentService.create(student);
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable ("id") int id) {
        logger.info("getStudentById is invoked with Student Id {}", id);
        return studentService.getStudentById(id);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable ("id") int id) {
        return studentService.deleteStudentById(id);
    }
}
