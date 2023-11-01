package com.jacobcouch.Application.service;

import com.jacobcouch.Application.dao.CourseDAO;
import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO theDAO) {
        courseDAO = theDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Optional<Course> findById(int theId) {
        return courseDAO.findById(theId);
    }

    @Override
    public List<Student> findStudentsByCourseId(int theId) {
        Optional<Course> theCourse = courseDAO.findById(theId);
        List<Student> students = theCourse.get().getStudents();
        return students;
    }

    @Override
    public Course save(Course theStudent) {
        return courseDAO.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        courseDAO.deleteById(theId);
    }
}
