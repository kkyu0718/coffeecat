package com.coffeecat.coffeecatdatareview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("select r from Review r")
    Stream<Review> findAllReviewStream();
}
