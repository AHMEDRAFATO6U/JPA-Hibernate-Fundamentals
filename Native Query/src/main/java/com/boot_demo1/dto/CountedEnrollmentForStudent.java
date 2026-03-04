package com.boot_demo1.dto;

import com.boot_demo1.entities.Student;

public record CountedEnrollmentForStudent(Student s ,Long count) {
}
