package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Capsule;

import java.util.List;
import java.util.Optional;

public interface CapsuleService {
    List<Capsule> findAllCapsule();
    Optional<Capsule> findCapsuleByCapsuleId(int capsuleId);
}
