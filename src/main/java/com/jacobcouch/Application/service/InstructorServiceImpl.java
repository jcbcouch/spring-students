package com.jacobcouch.Application.service;

import com.jacobcouch.Application.dao.InstructorDAO;
import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Instructor;
import com.jacobcouch.Application.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    private InstructorDAO instructorDAO;

    @Autowired
    public InstructorServiceImpl(InstructorDAO theInstructorDAO) {
        instructorDAO = theInstructorDAO;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    public Instructor findById(int theId) {
        return instructorDAO.findById(theId);
    }

    public List<Course> findCoursesByInstructorId(int theId) {
        Instructor theInstructor = instructorDAO.findById(theId);
        List<Course> courses = theInstructor.getCourses();
        return courses;
    }

    @Override
    public Instructor save(Instructor theStudent) {
        return instructorDAO.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        instructorDAO.deleteById(theId);
    }
}
