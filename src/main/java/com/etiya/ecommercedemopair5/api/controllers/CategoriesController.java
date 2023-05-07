package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.UpdateCustomerResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.entities.concrete.Category;
import com.etiya.ecommercedemopair5.business.abstracts.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public DataResult<List<ListCategoryResponse>> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("getWithPagination")
    public DataResult<Page<ListCategoryResponse>> getAll(@RequestParam("page")int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return categoryService.getAllWithPagination(pageable);
    }


    /*@GetMapping("/{id}")
    public Category getById(@PathVariable Integer id){
        return categoryService.getById(id);
    }*/

    @PutMapping("")
    public DataResult<UpdateCategoryResponse> update(@Valid @RequestBody UpdateCategoryRequest updateCategoryRequest){
        return categoryService.update(updateCategoryRequest);
    }

    @PostMapping("/add")
    public DataResult<AddCategoryResponse> add(@RequestBody AddCategoryRequest addCategoryRequest){
        return categoryService.add(addCategoryRequest);
    }
}
