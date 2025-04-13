package com.example.filmexplorer.controller;

import com.example.filmexplorer.dto.MovieItem;
import com.example.filmexplorer.service.MovieFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.filmexplorer.entity.FavoriteEntry;
import com.example.filmexplorer.repo.FavoriteRepo;

@Controller
public class ExploreController {

    @Autowired
    private MovieFetchService movieFetch;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("collection", movieFetch.fetchTrending().getResults());
        return "home";
    }

    @GetMapping("/film/{id}")
    public String details(@PathVariable int id, Model model) {
        model.addAttribute("film", movieFetch.getById(id));
        return "film";
    }

    @GetMapping("/search")
    public String search(@RequestParam String q, Model model) {
        model.addAttribute("collection", movieFetch.searchByKeyword(q).getResults());
        model.addAttribute("searchTerm", q);
        return "home";
    }

    @Autowired
    private FavoriteRepo favoriteRepo;

    @PostMapping("/fav/add/{id}")
    public String addToFavorites(@PathVariable int id) {
        var movie = movieFetch.getById(id);

        FavoriteEntry entry = new FavoriteEntry();
        entry.setId(movie.getId());
        entry.setTitle(movie.getTitle());
        entry.setCover(movie.getCover());
        entry.setLaunched(movie.getLaunched());
        entry.setScore(movie.getScore());

        favoriteRepo.save(entry);
        return "redirect:/fav/list";
    }

    @GetMapping("/fav/list")
    public String viewFavorites(Model model) {
        model.addAttribute("favorites", favoriteRepo.findAll());
        return "favorites";
    }

    @PostMapping("/fav/remove/{id}")
    public String removeFavorite(@PathVariable int id) {
        favoriteRepo.deleteById(id);
        return "redirect:/fav/list";
    }
}