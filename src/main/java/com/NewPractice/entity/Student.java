package com.NewPractice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "student_name", nullable = false, length = 55)
    private String studentName;

    @Column(name = "student_about", nullable = false, length = 55)
    private String studentAbout;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

}