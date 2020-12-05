package com.mipinapi.uploadings.java_version.config;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentConfig {

    @Bean
    public static XSSFWorkbook workbook() {
        return new XSSFWorkbook();
    }

}
