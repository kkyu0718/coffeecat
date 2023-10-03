package com.coffeecat.coffeecatdatareview;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = JpaTestConfig.class)
public class EntityMangerTest {
    @Autowired
    private EntityManager em;

    @Autowired
    private ReviewRepository reviewRepository;

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

    @Test
    @Rollback(value = false)
    public void test1() {
        Review save = reviewRepository.save(review);
        Assertions.assertThat(save).isEqualTo(review);
    }

    @Test
    public void test2() {
        JpaEntityInformation<Review, ?> entityInformation = JpaEntityInformationSupport.getEntityInformation(Review.class, em);
        reviewRepository.save(review);


        em.flush();
        em.clear();
        reviewRepository.save(review);

        Assertions.assertThat(reviewRepository.findAll().size()).isEqualTo(1);

    }
}
