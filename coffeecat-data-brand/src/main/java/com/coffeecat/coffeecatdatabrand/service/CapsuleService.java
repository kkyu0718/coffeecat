package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import com.coffeecat.coffeecatdatabrand.repository.CapsuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapsuleService {
    private final CapsuleRepository capsuleRepository;

    public CapsuleService(CapsuleRepository capsuleRepository) {
        this.capsuleRepository = capsuleRepository;
    }

    public List<Capsule> findAllCapsule() {
        return capsuleRepository.findAll();
    }

    public Optional<Capsule> findCapsuleByCapsuleId(int capsuleId) {
        return capsuleRepository.findById(capsuleId);
    }

    public List<Capsule> findCapsuleByCapsuleName(String capsuleName) {
        return capsuleRepository.findByCapsuleName(capsuleName);
    }

    public List<Capsule> findCapsuleByBrandName(String brandName) {
        return capsuleRepository.findByBrand_brandName(brandName);
    }
}
