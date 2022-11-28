package com.mimecast.books.rest;

import com.mimecast.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> createAuthor(String author) throws IOException, URISyntaxException, InterruptedException {
        authorService.createAuthor(author);
        return ResponseEntity.noContent().build();
    }

    //todo: implement getAuthor
}

