package com.example.POS.controller;

import com.example.POS.dto.CategoryDTO;
import com.example.POS.dto.CategoryDTOSave;
import com.example.POS.dto.CategoryDTOUpdate;
import com.example.POS.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/save")
    public String saveCategory(@RequestBody CategoryDTOSave categoryDTOSave) {
        return categoryService.addCategory(categoryDTOSave);
    }

    @GetMapping(path = "/getAllCategories")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PutMapping(path = "/updateCategory")
    public String updateCategory(@RequestBody CategoryDTOUpdate categoryDTOUpdate) {
        return categoryService.updateCategory(categoryDTOUpdate);
    }

//    @DeleteMapping(path = "/deleteCategory/{categoryId}")
//    public String deleteCategory(@PathVariable(value = "categoryId") int categoryId) {
//        return categoryService.deleteCategory(categoryId);
//    }

    @DeleteMapping(path = "/deleteCategory")
    public String deleteCategory(@RequestParam(value = "categoryId") int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
