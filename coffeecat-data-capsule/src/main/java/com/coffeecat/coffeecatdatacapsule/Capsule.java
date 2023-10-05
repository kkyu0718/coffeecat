package com.coffeecat.coffeecatdatacapsule;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    private LocalDateTime createdAt;
}
