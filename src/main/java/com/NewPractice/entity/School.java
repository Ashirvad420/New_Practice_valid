package com.NewPractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "school_name", nullable = false,length = 43)
    private String schoolName;

    @Column(name = "school_location", nullable = false,length = 55)
    private String schoolLocation;

    @Column(name = "school_popu", nullable = false,length = 54)
    private String schoolPopu;

}