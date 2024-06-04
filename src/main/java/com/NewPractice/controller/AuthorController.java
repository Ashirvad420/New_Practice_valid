package com.NewPractice.controller;

import com.NewPractice.entity.Author;
import com.NewPractice.service.Impl.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PostMapping("/auth")
    public ResponseEntity<?> createAuthor(@RequestBody Author author)
    {
      Author authors =   authorService.createAuthor(author);
      return new ResponseEntity<>(authors, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getAuthId(@PathVariable("id") Long useid)
    {
        Author author = authorService.getAuthId(useid);
        if (author!=null)
        {
            return new ResponseEntity<>(author,HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found Id",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteById(@PathVariable Long id)
    {
        Author author = authorService.DeleteById(id);
        return new ResponseEntity<>(author,HttpStatus.OK);
    }


    @PutMapping("/updates/{id}")
    public ResponseEntity<?> updateByid(@RequestBody Author author, @PathVariable Long id)
    {
        Author authors = authorService.updateByid(author,id);
        if (authors!=null)
        {
            return new ResponseEntity<>(authors,HttpStatus.OK);
        }
        return new ResponseEntity<>("Id is Not Found for this Location",HttpStatus.NOT_FOUND);
    }

}
