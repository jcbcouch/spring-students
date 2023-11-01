package com.jacobcouch.Application.controller;

import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Instructor;
import com.jacobcouch.Application.entity.Student;
import com.jacobcouch.Application.service.CourseService;
import com.jacobcouch.Application.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;
    private InstructorService instructorService;

    @Autowired
    public CourseController(CourseService theCourseService, InstructorService theInstructorService) {
        courseService = theCourseService;
        instructorService = theInstructorService;
    }

    @GetMapping("/list")
    public String listCourses(Model theModel) {
        List<Course> theCourses = courseService.findAll();
        theModel.addAttribute("courses", theCourses);
        return "courses/list-courses";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Course theCourse = new Course();
        List<Instructor> theInstructors = instructorService.findAll();
        theModel.addAttribute("course", theCourse);
        theModel.addAttribute("instructors", theInstructors);
        return "courses/course-form";
    }


    @PostMapping("/save")
    public String saveCourse(@RequestParam("title") String title,
                             @RequestParam("instructorId") int instructorId) {
        Course theCourse = new Course(title);
        Instructor theInstructor = instructorService.findById(instructorId);
        theCourse.setInstructor(theInstructor);
        courseService.save(theCourse);
        return "redirect:/courses/list";
    }

    @GetMapping("/studentsByCourseId")
    public String studentsByCourseId(Model theModel, @RequestParam("courseId") int theId) {
        List<Student> theStudents = courseService.findStudentsByCourseId(theId);
        theModel.addAttribute("students", theStudents);
        return "students/list-students";
    }
}
