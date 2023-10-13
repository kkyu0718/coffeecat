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
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;
    private String tagName;
    @OneToMany(mappedBy = "tag")
    private List<CapsuleTag> capsuleTags;
    @CreatedDate
    private LocalDateTime createdAt;
}
