package com.coffeecat.coffeecatbootbrand.controller;

import com.coffeecat.coffeecatbootbrand.dto.BrandDto;
import com.coffeecat.coffeecatbootbrand.service.BrandFacadeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/brands")
public class BrandController {
    private BrandFacadeService brandFacadeService;
    public BrandController(BrandFacadeService brandFacadeService) {
        this.brandFacadeService = brandFacadeService;
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getAllBrands() {
        return ResponseEntity.status(HttpStatus.OK).body(brandFacadeService.findAllBrand().stream().map(BrandDto::fromEntity).collect(Collectors.toList()));
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<BrandDto> getBrandById(@PathVariable int brandId) {
        return ResponseEntity.status(HttpStatus.OK).body(BrandDto.fromEntity(brandFacadeService.findBrandByBrandId(brandId)));
    }
}
