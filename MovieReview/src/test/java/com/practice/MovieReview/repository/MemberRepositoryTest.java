package com.practice.MovieReview.repository;

import com.practice.MovieReview.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMember() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("t" + i + "@test.com")
                    .pw("1111")
                    .nickname("reviewer" + i)
                    .build();
            memberRepository.save(member);
        });
    }
}