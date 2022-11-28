package com.mimecast.books.service;

import com.mimecast.books.model.Author;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class BookProviderImpl implements BookProvider {

    @Override
    public Author getFromNYTimes(String authorName) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.nytimes.com/svc/books/v3/reviews.json?author=Stephen+King&api-key=iNt32IUhhOdIcfe9JXAoBQxtXddHtMIi"))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return null;
    }

    @Override
    public Author getFromGoogle(String authorName) {
        return null;
    }

}
