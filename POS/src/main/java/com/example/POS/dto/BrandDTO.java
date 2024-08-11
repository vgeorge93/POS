package com.example.POS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {

    private int brandId;
    private String brandName;
    private boolean active;

    public BrandDTO(String brandName, boolean active) {
        this.brandName = brandName;
        this.active = active;
    }
}
