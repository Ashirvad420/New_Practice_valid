package com.NewPractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "property_user")
public class PropertyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 155)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 135)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true, length = 125)
    private String username;

    @Column(name = "email", nullable = false, unique = true, length = 250)
    private String email;

    @Column(name = "password", nullable = false, length = 234)
    private String password;

    @Column(name = "user_role", nullable = false, length = 25)
    private String userRole;

}