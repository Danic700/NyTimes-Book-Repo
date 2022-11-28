package com.mimecast.books.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @PostMapping
    public ResponseEntity<Void> createAuthor(/* todo: ... */) {
        /*
            todo: implement
         */
        return ResponseEntity.noContent().build();
    }

    //todo: implement getAuthor
}

