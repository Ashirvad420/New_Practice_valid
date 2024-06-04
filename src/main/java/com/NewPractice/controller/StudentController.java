package com.NewPractice.controller;

import com.NewPractice.entity.Student;
import com.NewPractice.service.Impl.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Student")
public class StudentController {

        private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/Std/{id}")
    public ResponseEntity<?> createStudent(@RequestBody Student student, @PathVariable Long id)
    {

       Student std = studentService.createStudent(student,id);
       return new ResponseEntity<>(std, HttpStatus.CREATED);
    }
}
