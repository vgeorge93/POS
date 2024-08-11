package com.example.POS.controller;

import com.example.POS.dto.ProductDTO;
import com.example.POS.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping(path = "/save")
    public String saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @GetMapping(path = "/getAllProducts")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}
