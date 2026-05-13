package com.example.BlogProject.controller;

import com.example.BlogProject.dto.category.CategoryRequestDTO;
import com.example.BlogProject.dto.category.CategoryResponseDTO;
import com.example.BlogProject.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponseDTO createCategory(@RequestBody CategoryRequestDTO requestDTO){
        return categoryService.createCategory(requestDTO);
    }

    @GetMapping
    public List<CategoryResponseDTO> getCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryResponseDTO updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO requestDTO){
        return categoryService.updateCategory(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
