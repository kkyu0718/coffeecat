package com.coffeecat.coffeecatbootbrand;

import com.coffeecat.coffeecatbootbrand.BusinessException;
import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import com.coffeecat.coffeecatdatabrand.service.CapsuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapsuleFacadeService{
    private final CapsuleService capsuleService;

    public CapsuleFacadeService(CapsuleService capsuleService) {
        this.capsuleService = capsuleService;
    }

    public List<Capsule> findAllCapsule() {
        return capsuleService.findAllCapsule();
    }

    public Capsule findCapsuleByCapsuleId(int capsuleId) {
        return capsuleService.findCapsuleByCapsuleId(capsuleId)
                .orElseThrow(BusinessException.CapsuleNotFoundException::new);
    }

    public List<Capsule> searchCapsule(CapsuleSearchCondition condition) {

    }
}
