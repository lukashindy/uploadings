package com.mipinapi.uploadings.java_version.rest;

import com.mipinapi.uploadings.java_version.service.documents.csv.CSVCategoryService;
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
public class CSVCategoryRestController {

    private final CSVCategoryService categoryService;

    public CSVCategoryRestController(CSVCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {

        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        categoryService.export(response);
    }
}
