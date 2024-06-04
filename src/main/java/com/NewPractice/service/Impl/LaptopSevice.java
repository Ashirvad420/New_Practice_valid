package com.NewPractice.service.Impl;

import com.NewPractice.entity.Laptop;
import com.NewPractice.repository.LaptopRepository;
import org.springframework.stereotype.Service;

@Service
public class LaptopSevice {

    private LaptopRepository laptopRepository;

    public LaptopSevice(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public Laptop createLaptop(Laptop laptop) {
        Laptop saved = laptopRepository.save(laptop);
        return saved;

    }
}
