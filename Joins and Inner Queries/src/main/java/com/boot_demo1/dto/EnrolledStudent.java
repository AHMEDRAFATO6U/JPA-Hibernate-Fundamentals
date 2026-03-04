package com.boot_demo1.dto;

import com.boot_demo1.entities.Enrollment;
import com.boot_demo1.entities.Student;

public record EnrolledStudent(Student s , Enrollment enrollment) {
}
