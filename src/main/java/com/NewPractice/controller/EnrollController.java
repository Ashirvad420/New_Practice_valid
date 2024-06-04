package com.NewPractice.controller;

import com.NewPractice.entity.Enrollments;
import com.NewPractice.service.Impl.EnrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Enroll")
public class EnrollController {

    private EnrollService enrollService;

    public EnrollController(EnrollService enrollService) {
        this.enrollService = enrollService;
    }

    @PostMapping("/cousr/{stId}/{courseid}")
    public ResponseEntity<?> EnrollName(@RequestBody Enrollments enrollments,@PathVariable Long stId, @PathVariable Long courseid)
    {
       Enrollments enrollments1 = enrollService.EnrollName(stId,courseid,enrollments);
       return new ResponseEntity<>(enrollments1, HttpStatus.CREATED);
    }
}
