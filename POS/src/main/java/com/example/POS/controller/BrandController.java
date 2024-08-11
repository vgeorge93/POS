package com.example.POS.controller;

import com.example.POS.dto.BrandDTO;
import com.example.POS.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;
    @PostMapping(path = "/save")
    public String saveBrand(@RequestBody BrandDTO brandDTO) {
        return brandService.addBrand(brandDTO);
    }
    @GetMapping(path = "/getAllBrands")
    public List<BrandDTO> getAllBrands() {
        return brandService.getAllBrands();
    }
    @PutMapping(path = "/updateBrand")
    public String updateBrand(@RequestBody BrandDTO brand) {
        return brandService.updateBrand(brand);
    }
    @DeleteMapping(path = "/deleteBrand")
    public String deleteBrand(@RequestParam(value = "brandId") int brandId) {
        return brandService.deleteBrand(brandId);
    }
}
