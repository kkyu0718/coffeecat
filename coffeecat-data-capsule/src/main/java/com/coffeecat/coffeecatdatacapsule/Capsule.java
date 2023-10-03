package com.coffeecat.coffeecatdatacapsule;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Capsule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int capsuleId;
    @ManyToOne
    private Brand brand;
    private String capsuleName;
    private String capsuleDetail;
    private String capsuleSize;
    private String capsuleImg;
    private LocalDateTime createdAt;
}
