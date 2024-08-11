package com.example.POS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int productId;
    private String productName;
    private boolean active;
    private int categoryId;
    private int brandId;
    private double price;
}
