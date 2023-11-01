package com.jacobcouch.Application.service;

import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Course> findCoursesByStudentId(int theId);

    List<Student> findAll();

    Optional<Student> findById(int theId);

    Student save(Student theEmployee);

    void deleteById(int theId);
}
