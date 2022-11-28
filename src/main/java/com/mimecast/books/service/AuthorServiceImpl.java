package com.mimecast.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private BookProvider bookProvider;
    @Override
    public void createAuthor(String authorName) throws IOException, InterruptedException, URISyntaxException {

     /*   if(*//* some param*//*){
            bookProvider.getFromNYTimes(authorName);
        }
        else {
            bookProvider.getFromGoogle(authorName);
        }*/

    }
}
