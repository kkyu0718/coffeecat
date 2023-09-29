package com.coffeecat.coffeecatdatauser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    private int userId;
    private String userNickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
