package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Brand;
import com.coffeecat.coffeecatdatabrand.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAllBrand() {
        return brandRepository.findAll();
    }

    public Optional<Brand> findBrandByBrandId(int brandId) {
        return brandRepository.findById(brandId);
    }
}
