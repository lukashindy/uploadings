package com.mipinapi.uploadings.converter;

import com.mipinapi.uploadings.dto.CategoryDTO;
import com.mipinapi.uploadings.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromDtoToCategory implements Converter<CategoryDTO, Category> {

    @Override
    public Category convert(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}
