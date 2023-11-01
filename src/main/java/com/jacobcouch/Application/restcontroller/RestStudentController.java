package com.jacobcouch.Application.restcontroller;

import com.jacobcouch.Application.dao.AppDAO;
import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Student;
import com.jacobcouch.Application.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class RestStudentController {
    private AppDAO appDAO;
    private StudentService studentService;
    public RestStudentController(AppDAO thedao, StudentService theStudentService) {
        appDAO = thedao;
        studentService = theStudentService;
    }


    @GetMapping("/")
    public List<Student> getStudents() {
        List<Student> theStudents = studentService.findAll();
        return theStudents;
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student theStudent) {
        theStudent.setId(0);
        Student dbStudent = studentService.save(theStudent);
        return dbStudent;
    }

    @PutMapping("/")
    public Student updateStudent (Student theStudent) {
        Student dbStudent = studentService.save(theStudent);
        return dbStudent;
    }

    @GetMapping("/coursesbystudentid/{studentId}")
    public List<Course> getStudents(@PathVariable int studentId) {
        List<Course> theCourses = studentService.findCoursesByStudentId(studentId);
        return theCourses;
    }
}
