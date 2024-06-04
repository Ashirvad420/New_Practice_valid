package com.NewPractice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shoe")
public class Shoes {

@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "shoes_color", nullable = false, length = 55)
    private String shoesColor;
    @Column(name = "shoe_name", nullable = false,length = 45)
    private String shoeName;

    @Column(name = "shoe_shops", nullable = false, length = 55)
    private String shoeShops;

  }
