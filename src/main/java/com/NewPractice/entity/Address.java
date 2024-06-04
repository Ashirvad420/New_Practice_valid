package com.NewPractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street", nullable = false, length = 55)
    private String street;

    @Column(name = "city", nullable = false, length = 55)
    private String city;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}