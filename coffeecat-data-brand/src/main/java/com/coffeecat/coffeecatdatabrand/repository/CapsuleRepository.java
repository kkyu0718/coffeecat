package com.coffeecat.coffeecatdatabrand.repository;

import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CapsuleRepository extends JpaRepository<Capsule, Integer>, JpaSpecificationExecutor<Capsule> {
    List<Capsule> findAll(Specification<Capsule> spec);
}
