package com.coffeecat.coffeecatbootbrand;

import com.coffeecat.coffeecatbootbrand.controller.CapsuleController;
import com.coffeecat.coffeecatbootbrand.dto.CapsuleSearchConditionDto;
import com.coffeecat.coffeecatbootbrand.service.CapsuleFacadeService;
import com.coffeecat.coffeecatdatabrand.entity.Brand;
import com.coffeecat.coffeecatdatabrand.entity.Capsule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CapsuleController.class)
class CapsuleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CapsuleFacadeService service;

    // ModelAttribute 의 field 는 nullable 하다
    @Test
    void searchCapsule_field_of_ModelAttribute_can_be_null() throws Exception {
        // given
        String capsuleName = "캡슐 이름";

        Brand brand = Brand.builder()
                .brandId(1)
                .brandName("네스프레소")
                .build();

        Capsule capsule = Capsule.builder()
                .capsuleId(1)
                .capsuleName("capsule 이름")
                .capsuleDetail("capsule 설명")
                .capsuleSize(Capsule.CapsuleSize.ESPRESSO)
                .capsuleImg("capsule img")
                .createdAt(LocalDateTime.now())
                .brand(brand)
                .capsuleTags(new ArrayList<>())
                .build();
        List<Capsule> result = List.of(capsule);
        given(service.searchCapsule(any(CapsuleSearchConditionDto.class))).willReturn(result);

        // when
        // queryParam에서 brandName 은 주어지지 않음
        ResultActions resultActions = mockMvc.perform(get("/brands/capsules/search")
                        .queryParam("capsuleName", capsuleName))
                .andDo(print());

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}