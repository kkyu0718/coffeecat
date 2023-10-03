package com.coffeecat.coffeecatdatacapsule;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Tag {
    @Id
    private int tagId;
    private String tagName;
    private LocalDateTime createdAt;
}
