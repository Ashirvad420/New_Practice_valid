package com.NewPractice.service.Impl;

import com.NewPractice.entity.Laptop;
import com.NewPractice.entity.Student;
import com.NewPractice.repository.LaptopRepository;
import com.NewPractice.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


@Service
public class StudentService {
    private StudentRepository studentRepository;
    private LaptopRepository laptopRepository;


    public StudentService(StudentRepository studentRepository,LaptopRepository laptopRepository) {
        this.laptopRepository=laptopRepository;
        this.studentRepository = studentRepository;

    }


    public Student createStudent(Student student, long id) {

        Laptop laptop = laptopRepository.findById(id).get();
        student.setLaptop(laptop);
        Student students = studentRepository.save(student);
        return students;



    }
}


