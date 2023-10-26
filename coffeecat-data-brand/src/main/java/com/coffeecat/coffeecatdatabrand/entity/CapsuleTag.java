package com.coffeecat.coffeecatdatabrand.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@IdClass(CapsuleTag.CapsuleTagId.class)
@EntityListeners(AuditingEntityListener.class)
public class CapsuleTag {
    @Id
    @ManyToOne
    @JoinColumn(name = "capsule_id")
    private Capsule capsule;
    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
    @CreatedDate
    private LocalDateTime createdAt;

    public class CapsuleTagId implements Serializable {
        private Capsule capsule;
        private Tag tag;
    }
}
