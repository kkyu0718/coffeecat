package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import com.coffeecat.coffeecatdatabrand.repository.CapsuleRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.Specification.where;

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

    public List<Capsule> searchCapsule(List<Specification<Capsule>> specs) {
        // 검색 조건이 없다면 findAll() 로직 실행
        if(specs.isEmpty()) return findAllCapsule();

        // multiple spec를 하나의 spec으로 merge
        Specification<Capsule> mergedSpec = specs.stream().reduce(where(null), Specification::and);
        return capsuleRepository.findAll(mergedSpec);
    }
}
