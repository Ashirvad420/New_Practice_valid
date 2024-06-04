package com.NewPractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author_name", nullable = false, length = 55)
    private String authorName;

    @Column(name = "author_age", nullable = false )
    private Integer authorAge;

    @Column(name = "nationality", nullable = false, length = 55)
    private String nationality;

}