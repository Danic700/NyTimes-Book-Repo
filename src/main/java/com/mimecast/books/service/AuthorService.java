package com.mimecast.books.service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AuthorService {

    public void createAuthor(String authorName) throws IOException, InterruptedException, URISyntaxException;

}
