package com.coffeecat.coffeecatdatareview;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    private int reviewId;

    private int userId;
    private int capsuleId;
    private boolean reviewRecommend;

    @Embedded
    private Taste taste;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Taste {
        private int reviewBitterness;
        private int reviewBody;
        private int reviewAcidity;
        private int reviewRoasting;
    }
}
