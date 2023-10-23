package com.coffeecat.coffeecatbootbrand;

import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands/capsules")
public class CapsuleController {
    private final CapsuleFacadeService capsuleFacadeService;

    public CapsuleController(CapsuleFacadeService capsuleFacadeService) {
        this.capsuleFacadeService = capsuleFacadeService;
    }

    @GetMapping
    public ResponseEntity<List<Capsule>> getAllCapsules() {
        return ResponseEntity.status(HttpStatus.OK).body(capsuleFacadeService.findAllCapsule());
    }

    @GetMapping("/{capsuleId}")
    public ResponseEntity<Capsule> getCapsuleById(@PathVariable int capsuleId) {
        return ResponseEntity.status(HttpStatus.OK).body(capsuleFacadeService.findCapsuleByCapsuleId(capsuleId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Capsule>> searchCapsule(@ModelAttribute("searchBy") CapsuleSearchCondition condition ) {
        //TODO condition 변화에 상관없이 search 진행되도록 설정
        return ResponseEntity.status(HttpStatus.OK).body(capsuleFacadeService.searchCapsule(condition));
    }

}
