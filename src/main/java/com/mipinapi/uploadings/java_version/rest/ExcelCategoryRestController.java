package com.mipinapi.uploadings.java_version.rest;

import com.mipinapi.uploadings.java_version.service.documents.excel.ExcelCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/category")
public class ExcelCategoryRestController {

    private final ExcelCategoryService excelCategoryService;

    public ExcelCategoryRestController(ExcelCategoryService excelCategoryService) {
        this.excelCategoryService = excelCategoryService;
    }

    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream)");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=categories_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        excelCategoryService.export(response);
    }

}
