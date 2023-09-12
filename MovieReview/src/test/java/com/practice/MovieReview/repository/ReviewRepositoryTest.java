package com.practice.MovieReview.repository;

import com.practice.MovieReview.entity.Member;
import com.practice.MovieReview.entity.Movie;
import com.practice.MovieReview.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMovieReviews() {
        // 리뷰 등록
        IntStream.rangeClosed(1, 200).forEach(i -> {
            // 영화번호
            Long mno = (long)(Math.random()*100) + 1;
            // 리뷰어번호
            Long mid = ((long)(Math.random()*100) + 1);
            Member member = Member.builder().mid(mid).build();

            Review movieReview = Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int)(Math.random()*5)+1)
                    .text("소감은,,," + i)
                    .build();

            reviewRepository.save(movieReview);
        });
    }

}
