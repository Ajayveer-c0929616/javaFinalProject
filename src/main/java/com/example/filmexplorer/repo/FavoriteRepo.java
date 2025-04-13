package com.example.filmexplorer.repo;

import com.example.filmexplorer.entity.FavoriteEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepo extends JpaRepository<FavoriteEntry, Integer> {
}
