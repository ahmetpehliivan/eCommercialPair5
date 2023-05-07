package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair5.entities.concrete.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    Category findByCategoryName(String categoryName);

    @Query(value = "Select new " +
            "com.etiya.ecommercedemopair5.business.dtos.responses.category.ListCategoryResponse(c.id, c.categoryName, c.description) " +
            "From Category c",
            nativeQuery = false)
    Page<ListCategoryResponse> getAll(Pageable pageable);
}
