package com.mipinapi.uploadings.java_version.service.documents.csv;

import com.mipinapi.uploadings.java_version.dto.CategoryDTO;
import com.mipinapi.uploadings.java_version.service.CategoryService;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class CSVCategoryService {

    private final CategoryService categoryService;

    public CSVCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void export(HttpServletResponse response) throws IOException {
        ICsvBeanWriter writer = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Category Id", "Name"};
        String[] nameMapping = {"id", "name"};
        writer.writeHeader(csvHeader);

        for (CategoryDTO categoryDTO: categoryService.findAll()) {
            writer.write(categoryDTO, nameMapping);
        }

        writer.close();
    }
}
