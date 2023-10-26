package com.coffeecat.coffeecatbootbrand.dto;

import com.coffeecat.coffeecatdatabrand.entity.CapsuleTag;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CapsuleTagDto {
    private int capsuleId;
    private int tagId;

    public static CapsuleTagDto fromEntity(CapsuleTag capsuleTag) {
        return CapsuleTagDto.builder()
                .capsuleId(capsuleTag.getCapsule().getCapsuleId())
                .tagId(capsuleTag.getTag().getTagId())
                .build();
    }
}
