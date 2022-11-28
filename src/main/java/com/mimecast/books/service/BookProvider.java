package com.mimecast.books.service;


import com.mimecast.books.model.Author;

import java.io.IOException;

public interface BookProvider {

    public Author getFromNYTimes(String authorName) throws IOException, InterruptedException;
    public Author getFromGoogle(String authorName);


}
