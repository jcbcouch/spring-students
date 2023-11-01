package com.jacobcouch.Application.service;

import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();

    List<Student> findStudentsByCourseId(int theId);

    Optional<Course> findById(int theId);

    Course save(Course theEmployee);

    void deleteById(int theId);
}
