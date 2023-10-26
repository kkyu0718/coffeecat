package com.coffeecat.coffeecatbootbrand.dto;

import com.coffeecat.coffeecatdatabrand.entity.Brand;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BrandDto {
    private int brandId;
    private String brandName;

    public static BrandDto fromEntity(Brand brand) {
        return BrandDto.builder()
                .brandId(brand.getBrandId())
                .brandName(brand.getBrandName())
                .build();
    }
}
