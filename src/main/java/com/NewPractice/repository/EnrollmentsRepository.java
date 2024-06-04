package com.NewPractice.repository;

import com.NewPractice.entity.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentsRepository extends JpaRepository<Enrollments, Long> {
}