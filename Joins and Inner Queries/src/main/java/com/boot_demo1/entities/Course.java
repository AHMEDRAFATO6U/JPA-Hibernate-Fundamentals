package com.boot_demo1.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String courseName;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollmentList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public void setEnrollmentList(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", enrollmentList=" + enrollmentList +
                '}';
    }
}
