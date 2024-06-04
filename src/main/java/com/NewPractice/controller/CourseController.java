package com.NewPractice.controller;

import com.NewPractice.entity.Course;
import com.NewPractice.service.Impl.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/Cour")
    public ResponseEntity<?> CourseName(@RequestBody Course course)
    {
        Course courses = courseService.CouseName(course);
        return new ResponseEntity<>(courses, HttpStatus.CREATED);
    }
}
