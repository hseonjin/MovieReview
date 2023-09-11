package com.practice.MovieReview.repository;

import com.practice.MovieReview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
