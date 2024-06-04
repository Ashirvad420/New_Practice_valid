package com.NewPractice.controller;

import com.NewPractice.entity.Employee;
import com.NewPractice.service.Impl.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/EmpPost")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee)
    {
        Employee emp = employeeService.createEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }
}
