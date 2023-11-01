package com.jacobcouch.Application.service;

import com.jacobcouch.Application.dao.StudentDAO;
import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO) {
        studentDAO = theStudentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Optional<Student> findById(int theId) {
        return studentDAO.findById(theId);
    }

    public List<Course> findCoursesByStudentId(int theId) {
        Optional<Student> theStudent = studentDAO.findById(theId);
        List<Course> Courses = theStudent.get().getCourses();
        return Courses;
    }

    @Override
    public Student save(Student theStudent) {
        return studentDAO.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        studentDAO.deleteById(theId);
    }
}
