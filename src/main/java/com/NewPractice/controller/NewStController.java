package com.NewPractice.controller;

import com.NewPractice.entity.NewStudent;
import com.NewPractice.service.Impl.NewStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/StNew")
public class NewStController {

    private NewStudentService newStudentService;

    public NewStController(NewStudentService newStudentService) {
        this.newStudentService = newStudentService;
    }

    @PostMapping("/NewStd")
    public ResponseEntity<?> NewStd(@RequestBody NewStudent newStudent)
    {
        NewStudent newStudent1 =newStudentService.NewStd(newStudent);
        return new ResponseEntity<>(newStudent1, HttpStatus.CREATED);
    }
}
