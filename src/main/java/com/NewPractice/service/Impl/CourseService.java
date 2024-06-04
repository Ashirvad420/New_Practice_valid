package com.NewPractice.service.Impl;


import com.NewPractice.entity.Course;
import com.NewPractice.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course CouseName(Course course) {
        Course courses = courseRepository.save(course);
        return course;
    }
}
