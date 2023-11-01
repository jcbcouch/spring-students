package com.jacobcouch.Application.dao;

import com.jacobcouch.Application.entity.Instructor;
import com.jacobcouch.Application.entity.InstructorDetail;
import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Student;
import java.util.List;

public interface AppDAO {
    List<Student> getAllStudents();

    List<Course> getCoursesByStudentId(int theId);

    void save(Student theStudent);
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student tempStudent);

    void deleteStudentById(int theId);
}
