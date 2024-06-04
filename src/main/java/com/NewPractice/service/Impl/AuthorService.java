package com.NewPractice.service.Impl;

import com.NewPractice.entity.Author;
import com.NewPractice.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author) {
       Author auth = authorRepository.save(author);
       return auth;
    }

    public Author getAuthId(Long id) {
       Optional<Author> auth=  authorRepository.findById(id);
       if(auth.isPresent())
       {
          Author ath = auth.get();
          return ath;
       }
       return null;
    }

    public Author DeleteById(Long id) {
       Optional<Author> auth = authorRepository.findById(id);
       if (auth.isPresent())
       {
           authorRepository.deleteById(id);
       }
       return null;
    }

    public Author updateByid(Author author, Long id) {
       Optional<Author> authApt = authorRepository.findById(id);
       if (authApt.isPresent())
       {
           Author auth = authApt.get();
           auth.setAuthorName(author.getAuthorName());
           Author saved = authorRepository.save(auth);
           return saved;
       }
       return null;
    }
}
