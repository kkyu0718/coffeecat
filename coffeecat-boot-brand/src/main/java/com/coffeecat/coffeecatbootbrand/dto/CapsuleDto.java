package com.coffeecat.coffeecatbootbrand.dto;

import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CapsuleDto {
    private int capsuleId;
    private int brandId;
    private String capsuleName;
    private String capsuleDetail;
    private String capsuleSize;
    private List<CapsuleTagDto> capsuleTags;

    public static CapsuleDto fromEntity(Capsule capsule) {
        return CapsuleDto.builder()
                .capsuleId(capsule.getCapsuleId())
                .brandId(capsule.getBrand().getBrandId())
                .capsuleName(capsule.getCapsuleName())
                .capsuleDetail(capsule.getCapsuleDetail())
                .capsuleSize(capsule.getCapsuleSize().name())
                .capsuleTags(capsule.getCapsuleTags().stream().map(CapsuleTagDto::fromEntity).collect(Collectors.toList()))
                .build();
    }
}
