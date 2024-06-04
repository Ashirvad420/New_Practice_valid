package com.NewPractice.service.Impl;

import com.NewPractice.entity.Address;
import com.NewPractice.entity.Author;
import com.NewPractice.entity.Book;
import com.NewPractice.repository.AuthorRepository;
import com.NewPractice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository,AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository=authorRepository;
    }

    public Book NewBooksCreate(Book book, Long id)
    {
        Author author = authorRepository.findById(id).get();
        book.setAuthor(author);
        Book books = bookRepository.save(book);
        return books;
    }

    public Book getBookdId(Long id) {
       Optional<Book>  books = bookRepository.findById(id);
       if (books.isPresent())
       {
           Book book = books.get();
           return book;
       }
        return null;
    }

    public Book DeleteById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent())
        {
           Book books =  book.get();
           bookRepository.deleteById(id);
        }
        return null;
    }

    public Book updateByid(Book book, Long id) {
       Optional<Book> books = bookRepository.findById(id);
       if (books.isPresent())
       {
           Book booked = books.get();
           booked.setAuthor(book.getAuthor());
          Book saved = bookRepository.save(booked);
       }
       return null;
    }


}
