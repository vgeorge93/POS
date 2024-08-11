package com.example.POS.service.IMPL;

import com.example.POS.dto.ProductDTO;
import com.example.POS.entities.Brand;
import com.example.POS.entities.Category;
import com.example.POS.entities.Product;
import com.example.POS.repo.BrandRepo;
import com.example.POS.repo.CategoryRepo;
import com.example.POS.repo.ProductRepo;
import com.example.POS.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceIMPL implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private BrandRepo brandRepo;

    @Override
    public String addProduct(ProductDTO productDTO) {
        Category category = categoryRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + productDTO.getCategoryId()));
        Brand brand = brandRepo.findById(productDTO.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found with ID: " + productDTO.getBrandId()));

        Product product = new Product(
                productDTO.getProductName(),
                productDTO.isActive(),
                productDTO.getPrice(),
                category,
                brand
        );
        productRepo.save(product);
        return "Save successful!";
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO(
                    product.getProductId(),
                    product.getProductName(),
                    product.isActive(),
                    product.getCategory().getCategoryId(),
                    product.getBrand().getBrandId(),
                    product.getPrice()
            );
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }
}
