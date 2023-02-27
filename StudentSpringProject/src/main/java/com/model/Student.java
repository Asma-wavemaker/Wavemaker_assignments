package com.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name="stud_id")
    private int stud_id;

    @Column(name="stud_name")
    private String stud_name;

    @Column(name="grade_id")
    private int grade_id;

    @Column(name = "attendence")
    private int attendence;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stud_id")
    private Performance performance;
    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
}
