package com.NewPractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "country_name", nullable = false, length = 55)
    private String countryName;

    @Column(name = "country_area", nullable = false, length = 55)
    private String countryArea;

    @Column(name = "country_popu", nullable = false,length = 44)
    private String countryPopu;

}