package com.jacobcouch.Application.controller;

import com.jacobcouch.Application.entity.Course;
import com.jacobcouch.Application.entity.Instructor;
import com.jacobcouch.Application.entity.InstructorDetail;
import com.jacobcouch.Application.service.InstructorDetailsService;
import com.jacobcouch.Application.service.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {
    private InstructorService instructorService;
    private InstructorDetailsService instructorDetailsService;

    public InstructorController(InstructorService theInstructorService,
                                InstructorDetailsService theInstructorDetailsService) {
        instructorService = theInstructorService;
        instructorDetailsService = theInstructorDetailsService;
    }

    @GetMapping("/list")
    public String listInstructors(Model theModel) {
        List<Instructor> theInstructors = instructorService.findAll();
        theModel.addAttribute("instructors", theInstructors);
        return "instructors/list-instructors";
    }

    @GetMapping("/coursesByInstructorId")
    public String listInstructors(Model theModel, @RequestParam("instructorId") int theId) {
        Instructor theInstructor = instructorService.findById(theId);
        List<Course> theCourses = theInstructor.getCourses();
        theModel.addAttribute("courses", theCourses);
        return "courses/list-courses";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd() {
        return "instructors/instructor-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@RequestParam("youtubeChannel") String youtubeChannel,
                               @RequestParam("hobby") String hobby,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("email") String email) {
        InstructorDetail theInstructorDetail = new InstructorDetail(youtubeChannel, hobby);
        InstructorDetail newInstructorDetail = instructorDetailsService.save(theInstructorDetail);

        Instructor theInstructor = new Instructor(firstName, lastName, email);
        theInstructor.setInstructorDetail(newInstructorDetail);
        instructorService.save(theInstructor);

        return "redirect:/instructors/list";
    }
}
