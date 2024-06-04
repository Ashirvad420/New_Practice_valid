package com.NewPractice.service.Impl;

import com.NewPractice.entity.NewStudent;
import com.NewPractice.repository.CourseRepository;
import com.NewPractice.repository.EnrollmentsRepository;
import com.NewPractice.repository.NewStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class NewStudentService {

    private NewStudentRepository newStudentRepository;


    public NewStudentService(NewStudentRepository newStudentRepository) {
        this.newStudentRepository = newStudentRepository;


    }

    public NewStudent NewStd(NewStudent newStudent) {

       NewStudent saved= newStudentRepository.save(newStudent);
       return saved;
    }
}
