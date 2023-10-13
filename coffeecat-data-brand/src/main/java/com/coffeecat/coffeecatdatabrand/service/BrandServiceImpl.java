package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Brand;
import com.coffeecat.coffeecatdatabrand.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

public class BrandServiceImpl implements BrandService{
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findBrandByBrandId(int brandId) {
        return brandRepository.findById(brandId);
    }
}
