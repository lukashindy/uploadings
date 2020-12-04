package com.mipinapi.uploadings.repository;

import com.mipinapi.uploadings.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
