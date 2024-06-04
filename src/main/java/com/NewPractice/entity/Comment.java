package com.NewPractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "text", nullable = false, length = 55)
    private String text;

    @Column(name = "email", nullable = false, length = 55)
    private String email;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
