package com.mimecast.books.utils;


import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Map;

public class HttpUtils {

    public HttpResponse<String> executeGet(String url, Map<String,String> queryParams){
    //simple http util for get Requests
        try {
            LinkedMultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<>();
            queryParams.entrySet().forEach(e -> linkedMultiValueMap.add(e.getKey(), e.getValue()));
            URI uri = UriComponentsBuilder.fromHttpUrl(url).queryParams(linkedMultiValueMap).build().toUri();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;

        }
        catch (Exception e){

        }


        return null;
    }

}
