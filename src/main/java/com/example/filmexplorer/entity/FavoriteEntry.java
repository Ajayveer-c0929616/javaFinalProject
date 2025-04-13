package com.example.filmexplorer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FavoriteEntry {

    @Id
    private int id;
    private String title;
    private String cover;
    private String launched;
    private double score;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCover() { return cover; }
    public void setCover(String cover) { this.cover = cover; }

    public String getLaunched() { return launched; }
    public void setLaunched(String launched) { this.launched = launched; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
}
