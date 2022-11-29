package com.mimecast.books.rest;

import com.mimecast.books.model.Author;
import com.mimecast.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> createAuthor(String authorName){
        authorService.createAuthor(authorName);
        return ResponseEntity.noContent().build(); //return 204, success and no content to display
    }

   @GetMapping
   public ResponseEntity<Author> getAuthor(String authorName){
       Optional<Author> author = authorService.getAuthor(authorName);
        if (author.isPresent()){
            return new ResponseEntity<>(author.get(), HttpStatus.OK); //return 200 with the author and all their books
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // return 204, no author found
        }

   }
}

