package com.coffeecat.coffeecatbootbrand.service;

import com.coffeecat.coffeecatbootbrand.exception.BusinessException;
import com.coffeecat.coffeecatdatabrand.entity.Brand;
import com.coffeecat.coffeecatdatabrand.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BrandFacadeService{
    private final BrandService brandService;

    public BrandFacadeService(BrandService brandService) {
        this.brandService = brandService;
    }

    public List<Brand> findAllBrand() {
        log.info("[BrandFacadeService] findAllBrand");
        return brandService.findAllBrand();
    }

    public Brand findBrandByBrandId(int brandId) {
        log.info("[BrandFacadeService] findBrandByBrandId");
        return brandService.findBrandByBrandId(brandId)
                .orElseThrow(BusinessException.BrandNotFoundException::new);
    }
}
