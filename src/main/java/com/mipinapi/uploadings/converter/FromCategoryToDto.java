package com.mipinapi.uploadings.converter;

import com.mipinapi.uploadings.dto.CategoryDTO;
import com.mipinapi.uploadings.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromCategoryToDto implements Converter<Category, CategoryDTO> {

    @Override
    public CategoryDTO convert(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}
