package com.example.POS.service;

import com.example.POS.dto.CategoryDTO;
import com.example.POS.dto.CategoryDTOSave;
import com.example.POS.dto.CategoryDTOUpdate;

import java.util.List;

public interface CategoryService {
    String addCategory(CategoryDTOSave categoryDTOSave);
    List<CategoryDTO> getAllCategories();

    String updateCategory(CategoryDTOUpdate categoryDTOUpdate);

    String deleteCategory(int categoryId);
}
