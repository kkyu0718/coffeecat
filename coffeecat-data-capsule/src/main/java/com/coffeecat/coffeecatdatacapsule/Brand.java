package com.coffeecat.coffeecatdatacapsule;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;
    private String brandName;
    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "capsuleId")
    private List<Capsule> capsules;
}
