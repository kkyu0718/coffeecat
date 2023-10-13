package com.coffeecat.coffeecatdatabrand.repository;

import com.coffeecat.coffeecatdatabrand.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
