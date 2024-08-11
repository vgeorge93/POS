package com.example.POS.service;

import com.example.POS.dto.BrandDTO;

import java.util.List;

public interface BrandService {
    String addBrand(BrandDTO brandDTO);

    List<BrandDTO> getAllBrands();

    String updateBrand(BrandDTO brand);

    String deleteBrand(int brandId);
}
