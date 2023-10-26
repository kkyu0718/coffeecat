package com.coffeecat.coffeecatbootbrand.dto;

import com.coffeecat.coffeecatbootbrand.model.CapsuleSearchConditionSpec;
import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CapsuleSearchConditionDto {
    // 조건 추가된다면 CapsuleSearchConditionSpec 추가 필요
    private String capsuleName;
    private String brandName;

    public static List<Specification<Capsule>> toPredicates(CapsuleSearchConditionDto condition) {
        List<Specification<Capsule>> specs = new ArrayList<>();

        if(condition.getCapsuleName() != null) specs.add(CapsuleSearchConditionSpec.containsCapsuleName(condition.getCapsuleName()));
        if(condition.getBrandName() != null) specs.add(CapsuleSearchConditionSpec.containsBrandName(condition.getBrandName()));
        return specs;
    }
}
