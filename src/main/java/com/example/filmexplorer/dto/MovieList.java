package com.example.filmexplorer.dto;

import java.util.List;

public class MovieList {
    private List<MovieItem> results;

    public List<MovieItem> getResults() {
        return results;
    }

    public void setResults(List<MovieItem> results) {
        this.results = results;
    }
}