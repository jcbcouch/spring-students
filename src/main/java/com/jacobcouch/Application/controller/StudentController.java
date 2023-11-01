package com.jacobcouch.Application.controller;

import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Student;
import com.jacobcouch.Application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService theService) {
        studentService = theService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Student> theStudents = studentService.findAll();
        theModel.addAttribute("students", theStudents);
        return "students/list-students";
    }

    @GetMapping("/coursesByStudentId")
    public String coursesByStudentId(Model theModel, @RequestParam("studentId") int theId) {
        List<Course> theCourses = studentService.findCoursesByStudentId(theId);
        theModel.addAttribute("courses", theCourses);
        return "courses/list-courses";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "students/student-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Student theStudent) {
        studentService.save(theStudent);
        return "redirect:/students/list";
    }
}
