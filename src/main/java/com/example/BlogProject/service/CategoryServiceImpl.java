package com.example.BlogProject.service;

import com.example.BlogProject.dto.category.CategoryRequestDTO;
import com.example.BlogProject.dto.category.CategoryResponseDTO;
import com.example.BlogProject.exception.ResourceNotFoundException;
import com.example.BlogProject.model.Category;
import com.example.BlogProject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //mapper
    private CategoryResponseDTO mapToDTO(Category category){
        return new CategoryResponseDTO(
                category.getId(),
                category.getName()
        );
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO){
        Category category = new Category();
        category.setName(requestDTO.getName());

        Category savedCategory = categoryRepository.save(category);

        return mapToDTO(savedCategory);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Category not found with id: " +id)
                );
         return mapToDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO requestDTO){
        Category category = categoryRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException("Category not found with id: " + id)
                );
        category.setName(requestDTO.getName());

        Category updatedCategory = categoryRepository.save(category);

        return mapToDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}

