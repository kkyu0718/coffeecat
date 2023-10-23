package com.coffeecat.coffeecatdatabrand.repository;

import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapsuleRepository extends JpaRepository<Capsule, Integer> {
    List<Capsule> findByCapsuleName(String capsuleName);

    List<Capsule> findByBrand_brandName(String brandName);
}
