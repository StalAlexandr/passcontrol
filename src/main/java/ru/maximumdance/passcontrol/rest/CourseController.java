package ru.maximumdance.passcontrol.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maximumdance.passcontrol.model.Course;
import ru.maximumdance.passcontrol.model.Person;
import ru.maximumdance.passcontrol.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/")
    public List<Course> root() {
        return courseService.getAll();
    }
}
