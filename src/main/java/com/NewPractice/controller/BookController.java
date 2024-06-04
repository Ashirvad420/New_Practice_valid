package com.NewPractice.controller;

import com.NewPractice.entity.Author;
import com.NewPractice.entity.Book;
import com.NewPractice.service.Impl.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books/{id}")

    public ResponseEntity<?> NewBooksCreate(@RequestBody Book book,@PathVariable Long id)
    {
        Book books =bookService.NewBooksCreate(book,id);
        return new ResponseEntity<>(books, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBookdId(@PathVariable Long id)
    {
        Book book = bookService.getBookdId(id);
        if (book!=null)
        {
            return new ResponseEntity<>(book,HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found Id",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("Delete/{id}")
    public ResponseEntity<?> DeleteByid(@PathVariable Long id)
    {
        Book book = bookService.DeleteById(id);
        if (book!=null)
        {
            return new ResponseEntity<>(book,HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found id for delete",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<?> updateByid(@RequestBody Book book, @PathVariable Long id)
    {
        Book books = bookService.updateByid(book,id);

        if (book!=null)
        {
            return new ResponseEntity<>(book,HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found id for delete",HttpStatus.NOT_FOUND);
    }
}
