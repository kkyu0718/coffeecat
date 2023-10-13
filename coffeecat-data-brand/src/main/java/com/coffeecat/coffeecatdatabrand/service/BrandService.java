package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<Brand> findAllBrand();
    Optional<Brand> findBrandByBrandId(int brandId);
}
