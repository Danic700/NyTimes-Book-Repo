package com.mimecast.books.service;

import com.mimecast.books.model.Author;
import com.mimecast.books.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService{


    private static final Map<String, BookProvider> providers;
    static{
        providers = new HashMap<>() {{
            put("NyTimes", new NYTimesBookProvider());
            put("Google", new GoogleBookProvider());
        }};
    }
    //

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private Environment environment;

    @Override
    public void createAuthor(String authorName) {
        List<Author> authorsList = authorRepository.findAll();      //make sure there's no double insertion of Authors to DB
        boolean authorExist = authorsList.stream().anyMatch(o -> o.getName().equals(authorName));
        if(!authorExist) {
            BookProvider provider = providers.get(environment.getProperty("book.provider"));  //switching between providers is transparent, only need to change in app.properties
            Author author = provider.getFromProvider(authorName);
            if (author != null) {
                authorRepository.save(author);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author Not Found");
            }
        }
    }

    @Override
    public Optional<Author> getAuthor(String authorName) {
        List<Author> authorsList = authorRepository.findAll();
        Optional<Author> author =  authorsList.stream().filter(o -> o.getName().equals(authorName)).findFirst();
        return author;
    }
}
