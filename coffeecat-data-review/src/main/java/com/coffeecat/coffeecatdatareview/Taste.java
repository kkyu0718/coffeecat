package com.coffeecat.coffeecatdatareview;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Taste {
    private int reviewBitterness;
    private int reviewBody;
    private int reviewAcidity;
    private int reviewRoasting;
}
