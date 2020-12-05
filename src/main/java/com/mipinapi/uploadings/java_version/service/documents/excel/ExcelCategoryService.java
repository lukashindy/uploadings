package com.mipinapi.uploadings.java_version.service.documents.excel;

import com.mipinapi.uploadings.java_version.dto.CategoryDTO;
import com.mipinapi.uploadings.java_version.service.CategoryService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class ExcelCategoryService {

    private final CategoryService categoryService;
    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelCategoryService(XSSFWorkbook workbook, CategoryService categoryService) {
        this.workbook = workbook;
        this.categoryService = categoryService;
    }

    private void writeHeaderLine() {
        sheet = workbook.   createSheet("Categories" + 10);
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Category Id", style);
        createCell(row, 1, "Name", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer)
            cell.setCellValue((Integer) value);
        if (value instanceof Long)
            cell.setCellValue((Long) value);
        else if (value instanceof Boolean)
            cell.setCellValue((Boolean) value);
        else
            cell.setCellValue((String) value);
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (CategoryDTO categoryDTO : categoryService.findAll()) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, categoryDTO.getId(), style);
            createCell(row, columnCount++, categoryDTO.getName(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}
