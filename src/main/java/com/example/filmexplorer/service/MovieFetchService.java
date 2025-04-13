package com.example.filmexplorer.service;

import com.example.filmexplorer.dto.MovieList;
import com.example.filmexplorer.dto.MovieItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieFetchService {

    @Value("${film.api.key}")
    private String key;

    @Value("${film.api.base-url}")
    private String base;

    private final RestTemplate rest = new RestTemplate();

    public MovieList fetchTrending() {
        String url = UriComponentsBuilder.fromHttpUrl(base + "/movie/popular")
                .queryParam("api_key", key)
                .toUriString();
        return rest.getForObject(url, MovieList.class);
    }

    public MovieItem getById(int id) {
        String url = UriComponentsBuilder.fromHttpUrl(base + "/movie/" + id)
                .queryParam("api_key", key)
                .toUriString();
        return rest.getForObject(url, MovieItem.class);
    }

    public MovieList searchByKeyword(String q) {
        String url = UriComponentsBuilder.fromHttpUrl(base + "/search/movie")
                .queryParam("api_key", key)
                .queryParam("query", q)
                .toUriString();
        return rest.getForObject(url, MovieList.class);
    }
}