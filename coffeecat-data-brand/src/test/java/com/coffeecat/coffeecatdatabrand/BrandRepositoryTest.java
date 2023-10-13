package com.coffeecat.coffeecatdatabrand;

import com.coffeecat.coffeecatdatabrand.entity.Brand;
import com.coffeecat.coffeecatdatabrand.repository.BrandRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;

@DataJpaTest
@EnableJpaRepositories(basePackages = "com.coffeecat.coffeecatdatabrand")
@EntityScan(basePackages = "com.coffeecat.coffeecatdatabrand")
public class BrandRepositoryTest {
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    EntityManager em;

    @Test
    void save() {
        // given
        Brand brand = Brand.builder()
                .brandId(1)
                .brandName("test")
                .createdAt(LocalDateTime.now())
                .build();

        // when
        brandRepository.save(brand);

        em.flush();
        em.clear();

        // then
        Assertions.assertThat(brandRepository.findAll().size()).isEqualTo(1);
    }


}
