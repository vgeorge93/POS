package com.example.POS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTOUpdate {

    private int categoryId;
    private String categoryName;
    private boolean active;
}
