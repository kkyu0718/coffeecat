package com.coffeecat.coffeecatdatacapsule;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@IdClass(CapsuleTag.CapsuleTagId.class)
@EntityListeners(AuditingEntityListener.class)
public class CapsuleTag {
    @Id
    @ManyToOne
    private Capsule capsule;
    @Id
    @ManyToOne
    private Tag tag;
    @CreatedDate
    private LocalDateTime createdAt;

    public class CapsuleTagId implements Serializable {
        private Capsule capsule;
        private Tag tag;
    }
}
