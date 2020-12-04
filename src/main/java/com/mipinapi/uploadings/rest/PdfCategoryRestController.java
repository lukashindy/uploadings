package com.mipinapi.uploadings.rest;

import com.mipinapi.uploadings.service.documents.excel.ExcelCategoryService;
import com.mipinapi.uploadings.service.documents.pdf.PDFCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/pdf")
public class PdfCategoryRestController {

    private final PDFCategoryService pdfCategoryService;

    public PdfCategoryRestController(PDFCategoryService pdfCategoryService) {
        this.pdfCategoryService = pdfCategoryService;
    }

    @GetMapping("/category")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=categories_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        pdfCategoryService.export(response);
    }

}
