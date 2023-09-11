package com.practice.MovieReview.repository;

import com.practice.MovieReview.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
