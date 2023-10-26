package com.coffeecat.coffeecatbootbrand.service;

import com.coffeecat.coffeecatbootbrand.exception.BusinessException;
import com.coffeecat.coffeecatbootbrand.dto.CapsuleSearchConditionDto;
import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import com.coffeecat.coffeecatdatabrand.service.CapsuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class CapsuleFacadeService{
    private final CapsuleService capsuleService;

    public CapsuleFacadeService(CapsuleService capsuleService) {
        this.capsuleService = capsuleService;
    }

    public List<Capsule> findAllCapsule() {
        log.info("[CapsuleFacadeService] findAllCapsule");
        return capsuleService.findAllCapsule();
    }

    public Capsule findCapsuleByCapsuleId(int capsuleId) {
        log.info("[CapsuleFacadeService] findCapsuleByCapsuleId");
        return capsuleService.findCapsuleByCapsuleId(capsuleId)
                .orElseThrow(BusinessException.CapsuleNotFoundException::new);
    }

    public List<Capsule> searchCapsule(CapsuleSearchConditionDto condition) {
        log.info("[CapsuleFacadeService] searchCapsule");
        return capsuleService.searchCapsule(CapsuleSearchConditionDto.toPredicates(condition));
    }
}
