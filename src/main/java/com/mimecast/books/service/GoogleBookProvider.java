package com.mimecast.books.service;

import com.mimecast.books.model.Author;
import com.mimecast.books.model.Book;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
@Service
@ConditionalOnProperty(name = "book.provider", havingValue = "Google")
public class GoogleBookProvider implements BookProvider{


    @Override
    public Author getFromProvider(String authorName) {
        //implement in the future..

        return null;
    }

    @Override
    public List<Book> parseResponseFromProvider(HttpResponse<String> response) {
        return null;
    }


}
