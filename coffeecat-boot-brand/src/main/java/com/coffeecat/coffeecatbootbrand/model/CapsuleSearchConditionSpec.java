package com.coffeecat.coffeecatbootbrand.model;

import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import org.springframework.data.jpa.domain.Specification;

public class CapsuleSearchConditionSpec {
    public static Specification<Capsule> containsCapsuleName(String capsuleName) {
        return (root, query, cb) -> cb.like(root.get("capsuleName"), capsuleName);
    }

    public static Specification<Capsule> containsBrandName(String brandName) {
        return (root, query, cb) -> cb.like(root.get("brand").get("brandName"), brandName);
    }
}
