package com.weissbeerger.weisscinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
public class OmdbApiController {

    private final String API_KEY = "?apikey=bb182d9e";

    private final WebClient omdbApiClient;

    @Autowired
    public OmdbApiController (WebClient omdbApiClient) {
        this.omdbApiClient = omdbApiClient;
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getMovies(@RequestParam String search) {
        return omdbApiClient.get().uri(API_KEY + "&type=movie&s=" + search).retrieve().bodyToMono(String.class).block();
    }

    @GetMapping(value = "/movies/{imdbId}/details", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getMovieDetails(@PathVariable String imdbId) {
        return omdbApiClient.get().uri(API_KEY + "&type=movie&plot=full&i=" + imdbId).retrieve().bodyToMono(String.class).block();
    }
}
