package com.mimecast.books.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mimecast.books.model.Author;
import com.mimecast.books.model.Book;

import org.springframework.stereotype.Service;


import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class NYTimesBookProvider implements BookProvider {


    private static final String providerURL = "https://api.nytimes.com/svc/books/v3/reviews.json";
    private static final String apiKey = "iNt32IUhhOdIcfe9JXAoBQxtXddHtMIi";

    @Override
    public Author getFromProvider(String authorName) {
        //get data from provider with httputils and then parse it
        Author author =  new Author();
        author.setName(authorName);
        Map queryParams = new HashMap<String, String>();
        queryParams.put("author", authorName);
        queryParams.put("api-key", apiKey);
        HttpResponse<String> response = httpUtils.executeGet(providerURL, queryParams);
        List<Book> bookList = parseResponseFromProvider(response);
        if(bookList != null) {
            author.setBookList(bookList);
            return author;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Book> parseResponseFromProvider(HttpResponse<String> response) {
        //parsing with ObjectMapper
        if(response.statusCode() == 200) {
            try {
                List<Book> booksList = new ArrayList<>();
                JsonNode jsonNode = objectMapper.readTree(response.body());
                JsonNode results = jsonNode.get("results");
                if(results.size() == 0)
                    throw new Exception("No Books for this author");
                for (JsonNode result : results) {
                    Book book = new Book();
                    book.setBookName(result.get("book_title").asText());
                    book.setBookSummary(result.get("summary").asText());
                    booksList.add(book);
                }
                return booksList;

            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }


}
