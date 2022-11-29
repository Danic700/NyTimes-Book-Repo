package com.mimecast.books.service;

import com.mimecast.books.model.Author;

import java.util.Optional;

public interface AuthorService {

     void createAuthor(String authorName);
     Optional<Author> getAuthor(String authorName);

}
