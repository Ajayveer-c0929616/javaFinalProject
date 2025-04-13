package com.example.filmexplorer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieItem {

    private int id;
    private String title;

    @JsonProperty("poster_path")
    private String cover;

    @JsonProperty("overview")
    private String synopsis;

    @JsonProperty("release_date")
    private String launched;

    @JsonProperty("vote_average")
    private double score;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCover() { return cover; }
    public void setCover(String cover) { this.cover = cover; }

    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public String getLaunched() { return launched; }
    public void setLaunched(String launched) { this.launched = launched; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
}