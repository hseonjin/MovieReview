package com.practice.MovieReview.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "movie") // movie entity와 연관관계를 가짐을 명시
public class MovieImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum; // image 번호
    private String uuid;
    private String imaName;
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
