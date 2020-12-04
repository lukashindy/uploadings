package com.mipinapi.uploadings.service;

import com.mipinapi.uploadings.converter.FromCategoryToDto;
import com.mipinapi.uploadings.converter.FromDtoToCategory;
import com.mipinapi.uploadings.dto.CategoryDTO;
import com.mipinapi.uploadings.model.Category;
import com.mipinapi.uploadings.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final FromCategoryToDto categoryToDto;
    private final FromDtoToCategory dtoToCategory;

    public CategoryService(CategoryRepository categoryRepository, FromCategoryToDto categoryToDto, FromDtoToCategory dtoToCategory) {
        this.categoryRepository = categoryRepository;
        this.categoryToDto = categoryToDto;
        this.dtoToCategory = dtoToCategory;
    }

    public List<CategoryDTO> findAll() {
        List<Category> list = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(list::add);
        return list.stream()
                .map(categoryToDto::convert)
                .collect(Collectors.toList());
    }

    private Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public CategoryDTO dtoFindById(Long id) {
        return categoryToDto.convert(findById(id));
    }

    public CategoryDTO save(CategoryDTO dto) {
        Category category = dtoToCategory.convert(dto);
        Category savedCategory = categoryRepository.save(category);
        return categoryToDto.convert(savedCategory);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
