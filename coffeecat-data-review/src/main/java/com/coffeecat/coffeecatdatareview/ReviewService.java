package com.coffeecat.coffeecatdatareview;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
