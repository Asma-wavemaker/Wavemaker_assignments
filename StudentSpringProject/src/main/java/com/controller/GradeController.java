package com.controller;

import com.model.Grade;
import com.services.GradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/grade")
public class GradeController {
    @Autowired
    GradeService gradeService;
    public static final Logger logger = LoggerFactory.getLogger(GradeController.class);
    @GetMapping
    public List<Grade> getGrade(){
        logger.info("Student Grade");
        return gradeService.getGrade();
    }

}
