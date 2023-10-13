package com.coffeecat.coffeecatdatabrand.repository;

import com.coffeecat.coffeecatdatabrand.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
