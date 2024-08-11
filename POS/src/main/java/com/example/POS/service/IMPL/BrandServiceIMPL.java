package com.example.POS.service.IMPL;

import com.example.POS.dto.BrandDTO;
import com.example.POS.entities.Brand;
import com.example.POS.repo.BrandRepo;
import com.example.POS.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceIMPL implements BrandService {

    @Autowired
    private BrandRepo brandRepo;

    @Override
    public String addBrand(BrandDTO brandDTO) {
        Brand brand = new Brand(brandDTO.getBrandName(), brandDTO.isActive());
        brandRepo.save(brand);
        return "Save successful!";
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        List<BrandDTO> brandsList = new ArrayList<>();
        brandRepo.findAll().forEach(b -> {
            brandsList.add(new BrandDTO(b.getBrandId(), b.getBrandName(), b.isActive()));
        });
        return brandsList;
    }

    @Override
    public String updateBrand(BrandDTO brandDTO) {
        if (brandRepo.existsById(brandDTO.getBrandId())) {
            Brand brand = brandRepo.findById(brandDTO.getBrandId()).orElse(null);
            if (brand != null) {
                brand.setBrandName(brandDTO.getBrandName());
                brand.setActive(brandDTO.isActive());
                brandRepo.save(brand);
                return "Update successful!";
            }
        }
        return "Brand id not found";
    }

    @Override
    public String deleteBrand(int brandId) {
        if (brandRepo.existsById(brandId)) {
            brandRepo.deleteById(brandId);
            return "Brand deleted";
        }
        return "Brand id not found. Can't be deleted";
    }
}
