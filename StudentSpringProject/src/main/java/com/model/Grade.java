package com.model;

import javax.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @Column(name="grade_id")
    private int grade_id;

    @Column(name="grade_type")
    private int grade_type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stud_id")
    private Student student;
    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getGrade_type() {
        return grade_type;
    }

    public void setGrade_type(int grade_type) {
        this.grade_type = grade_type;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
