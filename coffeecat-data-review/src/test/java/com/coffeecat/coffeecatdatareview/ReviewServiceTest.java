package com.coffeecat.coffeecatdatareview;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DataJpaTest
@ContextConfiguration(classes = JpaTestConfig.class)
class ReviewServiceTest {
    @Autowired
    private ReviewRepository reviewRepository;
    private int count = 100000;

    @Test
    void findAll() {
        long startTime = System.currentTimeMillis();

        List<Review> reviews = IntStream.rangeClosed(1, count)
                .mapToObj(i -> getReview()).toList();

        reviewRepository.saveAll(reviews);

        List<Review> saved = reviewRepository.findAll();
        Assertions.assertThat(saved).isNotNull();
        System.out.println("duration = " + (System.currentTimeMillis() - startTime));
    }

    @Test
    void findAllStream() {
        long startTime = System.currentTimeMillis();

        List<Review> reviews = IntStream.rangeClosed(1, count)
                .mapToObj(i -> getReview()).toList();

        reviewRepository.saveAllAndFlush(reviews);

        List<Review> saved = reviewRepository.findAllReviewStream().collect(Collectors.toList());
        Assertions.assertThat(saved).isNotNull();
        System.out.println("duration = " + (System.currentTimeMillis() - startTime));
    }

    private static Review getReview() {
        Review review = Review.builder()
                .reviewRecommend(false)
                .capsuleId(1)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .taste(Review.Taste.builder().build().builder()
                        .reviewAcidity(1)
                        .reviewBitterness(2)
                        .reviewBody(3)
                        .reviewRoasting(4)
                        .build())
                .build();
        return review;
    }
}