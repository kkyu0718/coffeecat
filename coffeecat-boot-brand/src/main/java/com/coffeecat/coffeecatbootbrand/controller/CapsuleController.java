package com.coffeecat.coffeecatbootbrand.controller;

import com.coffeecat.coffeecatbootbrand.dto.CapsuleDto;
import com.coffeecat.coffeecatbootbrand.service.CapsuleFacadeService;
import com.coffeecat.coffeecatbootbrand.dto.CapsuleSearchConditionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brands/capsules")
@Slf4j
public class CapsuleController {
    private final CapsuleFacadeService capsuleFacadeService;

    public CapsuleController(CapsuleFacadeService capsuleFacadeService) {
        this.capsuleFacadeService = capsuleFacadeService;
    }

    @GetMapping
    public ResponseEntity<List<CapsuleDto>> getAllCapsules() {
        return ResponseEntity.status(HttpStatus.OK).body(capsuleFacadeService.findAllCapsule().stream().map(CapsuleDto::fromEntity).collect(Collectors.toList()));
    }

    @GetMapping("/{capsuleId}")
    public ResponseEntity<CapsuleDto> getCapsuleById(@PathVariable int capsuleId) {
        return ResponseEntity.status(HttpStatus.OK).body(CapsuleDto.fromEntity(capsuleFacadeService.findCapsuleByCapsuleId(capsuleId)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CapsuleDto>> searchCapsule(@ModelAttribute CapsuleSearchConditionDto condition ) {
        return ResponseEntity.status(HttpStatus.OK).body(capsuleFacadeService.searchCapsule(condition).stream().map(CapsuleDto::fromEntity).collect(Collectors.toList()));
    }

}
