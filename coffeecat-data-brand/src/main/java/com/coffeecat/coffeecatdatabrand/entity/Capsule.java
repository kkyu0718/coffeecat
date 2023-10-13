package com.coffeecat.coffeecatdatabrand.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

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
    @OneToMany(mappedBy = "capsule")
    private List<CapsuleTag> capsuleTags;
    @CreatedDate
    private LocalDateTime createdAt;
}
