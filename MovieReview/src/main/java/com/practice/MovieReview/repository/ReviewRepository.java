package com.practice.MovieReview.repository;

import com.practice.MovieReview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
