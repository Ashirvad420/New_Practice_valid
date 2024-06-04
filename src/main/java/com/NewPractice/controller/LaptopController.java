package com.NewPractice.controller;

import com.NewPractice.entity.Laptop;
import com.NewPractice.service.Impl.LaptopSevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Laptop")
public class LaptopController {

    private LaptopSevice laptopSevice;

    public LaptopController(LaptopSevice laptopSevice) {
        this.laptopSevice = laptopSevice;
    }

    @PostMapping("/Laptop")
    public ResponseEntity<?> createLaptop(@RequestBody Laptop laptop)
    {
        Laptop lsp = laptopSevice.createLaptop(laptop);
        return new ResponseEntity<>(lsp, HttpStatus.CREATED);
    }
}
