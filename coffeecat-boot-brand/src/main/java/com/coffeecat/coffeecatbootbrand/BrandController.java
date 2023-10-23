package com.coffeecat.coffeecatbootbrand;

import com.coffeecat.coffeecatdatabrand.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/brands")
public class BrandController {
    private BrandFacadeService brandFacadeService;
    public BrandController(BrandFacadeService brandFacadeService) {
        this.brandFacadeService = brandFacadeService;
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        return ResponseEntity.status(HttpStatus.OK).body(brandFacadeService.findAllBrand());
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<Brand> getBrandById(@PathVariable int brandId) {
        return ResponseEntity.status(HttpStatus.OK).body(brandFacadeService.findBrandByBrandId(brandId));
    }
}
