package com.NewPractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "book_title", nullable = false, length = 55)
    private String bookTitle;

    @Column(name = "year_published", nullable = false, length = 55)
    private String yearPublished;

    @Column(name = "book_genre", nullable = false, length = 55)
    private String bookGenre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "author_id", nullable = false)
//    private Author author;

}