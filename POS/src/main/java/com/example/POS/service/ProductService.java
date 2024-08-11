package com.example.POS.service;

import com.example.POS.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    String addProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();
}
