package com.NewPractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "laptop_name", nullable = false, length = 55)
    private String laptopName;

    @Column(name = "laptop_model", nullable = false)
    private String laptopModel;

}