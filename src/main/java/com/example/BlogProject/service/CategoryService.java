package com.example.BlogProject.service;

import com.example.BlogProject.dto.category.CategoryRequestDTO;
import com.example.BlogProject.dto.category.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO getCategoryById(Long id);

    CategoryResponseDTO updateCategory(
            Long id,
            CategoryRequestDTO requestDTO
    );

    void deleteCategory(Long id);
}
