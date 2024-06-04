package com.NewPractice.service.Impl;

import com.NewPractice.entity.Employee;
import com.NewPractice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee createEmployee(Employee employee) {
       Employee emp = employeeRepository.save(employee);
       return emp;
    }
}
