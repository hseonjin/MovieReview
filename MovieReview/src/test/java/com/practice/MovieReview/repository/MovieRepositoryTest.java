package com.practice.MovieReview.repository;

import com.practice.MovieReview.entity.Movie;
import com.practice.MovieReview.entity.MovieImage;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieImageRepository imageRepository;

    @Commit
    @Transactional
    @Test
    public void insertMovies() {
        IntStream.rangeClosed(1, 100).forEach(i -> { // 10개 데이터 삽입
            Movie movie = Movie.builder().title("제목.." + i).build(); // movie 데이터 삽입
            System.out.println("-------------------");
            movieRepository.save(movie); // 삽입된 데이터 저장 -> save되면 생성되는 mno값을 이용하여 movieImage 추가
            int count = (int) (Math.random() * 5) + 1; // 1~5장까지 img 삽입 가능
            for (int j = 0; j < count; j++) {
                MovieImage movieImage = MovieImage.builder()
                        .uuid(String.valueOf(UUID.randomUUID()))
                        .movie(movie)
                        .imaName("test" + j + ".jpg")
                        .build();
                imageRepository.save(movieImage);
            }
        });
    }
}