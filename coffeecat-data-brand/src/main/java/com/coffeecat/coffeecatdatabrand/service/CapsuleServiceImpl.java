package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import com.coffeecat.coffeecatdatabrand.repository.CapsuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapsuleServiceImpl implements CapsuleService{
    private final CapsuleRepository capsuleRepository;

    public CapsuleServiceImpl(CapsuleRepository capsuleRepository) {
        this.capsuleRepository = capsuleRepository;
    }

    @Override
    public List<Capsule> findAllCapsule() {
        return capsuleRepository.findAll();
    }

    @Override
    public Optional<Capsule> findCapsuleByCapsuleId(int capsuleId) {
        return capsuleRepository.findById(capsuleId);
    }
}
