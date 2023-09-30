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

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = JpaTestConfig.class)
class ReviewServiceTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void findAll() {
        Review review = Review.builder()
                .reviewRecommend(false)
                .capsuleId(1)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .taste(Taste.builder()
                        .reviewAcidity(1)
                        .reviewBitterness(2)
                        .reviewBody(3)
                        .reviewRoasting(4)
                        .build())
                .build();
        reviewRepository.save(review);
        List<Review> all = reviewRepository.findAll();
        Assertions.assertThat(all).isNotNull();
    }
}