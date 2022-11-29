package com.mimecast.books.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mimecast.books.model.Author;
import com.mimecast.books.model.Book;
import com.mimecast.books.utils.HttpUtils;


import java.net.http.HttpResponse;
import java.util.List;

public interface BookProvider {

    //I was debating whether to make book p

    HttpUtils httpUtils = new HttpUtils();
    ObjectMapper objectMapper =  new ObjectMapper();
    Author getFromProvider(String authorName);
    List<Book> parseResponseFromProvider(HttpResponse<String> response);

}
