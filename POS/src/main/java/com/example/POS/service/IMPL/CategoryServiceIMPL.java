package com.example.POS.service.IMPL;

import com.example.POS.dto.CategoryDTO;
import com.example.POS.dto.CategoryDTOSave;
import com.example.POS.dto.CategoryDTOUpdate;
import com.example.POS.entities.Category;
import com.example.POS.repo.CategoryRepo;
import com.example.POS.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceIMPL implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public String addCategory(CategoryDTOSave categoryDTOSave) {
        Category category = new Category(
                categoryDTOSave.getCategoryName(),
                categoryDTOSave.isActive()
        );
        categoryRepo.save(category);
        return category.getCategoryName();
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryList = new ArrayList<>();
        categoryRepo.findAll().forEach(c -> {
            categoryList.add(new CategoryDTO(c.getCategoryId(), c.getCategoryName(), c.isActive()));
        });
        return categoryList;
    }

    @Override
    public String updateCategory(CategoryDTOUpdate categoryDTOUpdate) {
        if (categoryRepo.existsById(categoryDTOUpdate.getCategoryId())) {
            Category c = new Category(categoryDTOUpdate.getCategoryId(), "Bike", true);
            categoryRepo.save(c);
            return "Category updated successfully!";
        }
        return "Category id not found";
    }

    @Override
    public String deleteCategory(int categoryId) {
        if (categoryRepo.existsById(categoryId)) {
            categoryRepo.deleteById(categoryId);
            return "Category deleted";
        }
        return "Category id not found. Can't be deleted";
    }
}
