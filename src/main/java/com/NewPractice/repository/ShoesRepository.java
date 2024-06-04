package com.NewPractice.repository;

import com.NewPractice.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoesRepository extends JpaRepository<Shoes, Long> {
}