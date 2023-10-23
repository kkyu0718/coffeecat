package com.coffeecat.coffeecatbootbrand;

import com.coffeecat.coffeecatbootbrand.BusinessException;
import com.coffeecat.coffeecatdatabrand.entity.Brand;
import com.coffeecat.coffeecatdatabrand.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandFacadeService{
    private final BrandService brandService;

    public BrandFacadeService(BrandService brandService) {
        this.brandService = brandService;
    }

    public List<Brand> findAllBrand() {
        return brandService.findAllBrand();
    }

    public Brand findBrandByBrandId(int brandId) {
        return brandService.findBrandByBrandId(brandId)
                .orElseThrow(BusinessException.BrandNotFoundException::new);
    }
}
