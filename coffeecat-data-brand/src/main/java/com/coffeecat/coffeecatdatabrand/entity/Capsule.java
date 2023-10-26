package com.coffeecat.coffeecatdatabrand.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Capsule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int capsuleId;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    private String capsuleName;
    private String capsuleDetail;
    @Enumerated(EnumType.STRING)
    private CapsuleSize capsuleSize;
    private String capsuleImg;
    @OneToMany(mappedBy = "capsule")
    private List<CapsuleTag> capsuleTags;
    @CreatedDate
    private LocalDateTime createdAt;

    public static enum CapsuleSize {
        LUNGO, ESPRESSO
    }
}
