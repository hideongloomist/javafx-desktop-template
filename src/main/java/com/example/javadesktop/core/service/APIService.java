package com.example.javadesktop.core.service;

import com.example.javadesktop.core.dto.Header;
import com.example.javadesktop.core.dto.HttpError;
import com.example.javadesktop.core.dto.Request;
import com.example.javadesktop.core.dto.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class APIService {
    private static final Gson gson = new Gson();

    /**
     * getAPIRequest
     *
     * @description: get entity from api
     */
    public static Response getAPIRequest(String uri, Header headerDto, Class<Response> responseDto)
            throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers(headerDto.getHeadersList())
                .GET().build();
        return send(getRequest, responseDto);
    }

    /**
     * postAPIRequest
     *
     * @description: create entity from api
     */
    public static Response postAPIRequest(String uri, Header headerDto, Request bodyDto, Class<Response> responseDto)
            throws URISyntaxException, IOException, InterruptedException {
        String jsonBody = gson.toJson(bodyDto);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers(headerDto.getHeadersList())
                .POST(BodyPublishers.ofString(jsonBody)).build();
        return send(postRequest, responseDto);
    }

    /**
     * postAPIRequest
     *
     * @description: update all entities from api
     */
    public static Response putAPIRequest(String uri, Header headerDto, Request bodyDto, Class<Response> responseDto)
            throws URISyntaxException, IOException, InterruptedException {
        String jsonBody = gson.toJson(bodyDto);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers(headerDto.getHeadersList())
                .PUT(BodyPublishers.ofString(jsonBody)).build();
        return send(postRequest, responseDto);
    }

    /**
     * patchAPIRequest
     *
     * @description: update entity from api
     */
    public static Response patchAPIRequest(String uri, Header headerDto, Request bodyDto, Class<Response> responseDto)
            throws URISyntaxException, IOException, InterruptedException {
        String jsonBody = gson.toJson(bodyDto);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers(headerDto.getHeadersList())
                .method("PATCH", BodyPublishers.ofString(jsonBody)).build();
        return send(postRequest, responseDto);
    }

    /**
     * deleteAPIRequest
     *
     * @description: delete entity from api
     */
    public static Response deleteAPIRequest(String uri, Header headerDto, Class<Response> responseDto)
            throws URISyntaxException, IOException, InterruptedException {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers(headerDto.getHeadersList())
                .DELETE().build();
        return send(postRequest, responseDto);
    }

    private static Response send(HttpRequest request, Class<Response> responseDto) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(request, BodyHandlers.ofString());
        postResponse.body();
        if (postResponse.statusCode() == 200) {
            return gson.fromJson(postResponse.body(), (Type) responseDto);
        } else {
            return gson.fromJson(postResponse.body(), HttpError.class);
        }
    }
}