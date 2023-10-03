package com.coffeecat.coffeecatdatacapsule;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@IdClass(CapsuleTag.CapsuleTagId.class)
public class CapsuleTag {
    @Id
    @ManyToOne
    private Capsule capsule;

    @Id
    @ManyToOne
    private Tag tag;

    public class CapsuleTagId implements Serializable {
        private Capsule capsule;
        private Tag tag;
    }
}
