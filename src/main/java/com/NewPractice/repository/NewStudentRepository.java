package com.NewPractice.repository;

import com.NewPractice.entity.NewStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewStudentRepository extends JpaRepository<NewStudent, Long> {
}