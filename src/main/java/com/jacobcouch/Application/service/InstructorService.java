package com.jacobcouch.Application.service;


import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    List<Instructor> findAll();

    Instructor findById(int theId);

    public List<Course> findCoursesByInstructorId(int theId);

    Instructor save(Instructor theInstructor);

    void deleteById(int theId);
}
