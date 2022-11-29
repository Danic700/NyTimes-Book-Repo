package com.mimecast.books.service;

import com.mimecast.books.model.Author;
import com.mimecast.books.model.Book;

import java.net.http.HttpResponse;
import java.util.List;

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
