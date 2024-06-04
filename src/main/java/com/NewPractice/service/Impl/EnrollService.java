package com.NewPractice.service.Impl;

import com.NewPractice.entity.Course;
import com.NewPractice.entity.Enrollments;
import com.NewPractice.entity.NewStudent;
import com.NewPractice.repository.CourseRepository;
import com.NewPractice.repository.EnrollmentsRepository;
import com.NewPractice.repository.NewStudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollService {

    private EnrollmentsRepository enrollmentsRepository;
    private CourseRepository courseRepository;
    private NewStudentRepository newStudentRepository;

    public EnrollService(EnrollmentsRepository enrollmentsRepository,CourseRepository courseRepository,NewStudentRepository newStudentRepository) {
        this.enrollmentsRepository = enrollmentsRepository;
        this.courseRepository = courseRepository;
        this.newStudentRepository = newStudentRepository;
    }

    public Enrollments EnrollName(Long stId, Long courseid, Enrollments enrollments) {

        Optional<Course> course = courseRepository.findById(courseid);
        Optional<NewStudent> newstd =newStudentRepository.findById(stId);

        if(course.isPresent() && newstd.isPresent())
        {
           Course co = course.get();
           NewStudent newStudent = newstd.get();
           enrollments.setCourse(co);
           enrollments.setNewStudent(newStudent);
          Enrollments saved = enrollmentsRepository.save(enrollments);
          return saved;
        }
        return null;
    }

}
