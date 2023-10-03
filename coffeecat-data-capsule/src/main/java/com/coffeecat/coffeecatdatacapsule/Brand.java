package com.coffeecat.coffeecatdatacapsule;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;
    private String brandName;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "capsuleId")
    private List<Capsule> capsules;
}
