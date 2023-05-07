package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair5.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair5.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair5.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.utils.result.*;
import com.etiya.ecommercedemopair5.entities.concrete.Category;
import com.etiya.ecommercedemopair5.repositories.CategoryDao;
import com.etiya.ecommercedemopair5.business.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManager implements CategoryService {

    private final CategoryDao categoryDao;
    private final ModelMapperService modelMapperService;
    private final MessageSource messageSource;

    @Autowired
    public CategoryManager(CategoryDao categoryDao, ModelMapperService modelMapperService, MessageSource messageSource) {
        this.categoryDao = categoryDao;
        this.modelMapperService = modelMapperService;
        this.messageSource = messageSource;
    }

    @Override
    public DataResult<AddCategoryResponse> add(AddCategoryRequest addCategoryRequest) {
        checkIfCategoryWithSameNameExists(addCategoryRequest.getCategoryName());
        Category category = modelMapperService.forRequest().map(addCategoryRequest, Category.class);
        categoryDao.save(category);
        AddCategoryResponse addCategoryResponse = modelMapperService.forResponse().map(category, AddCategoryResponse.class);
        return new SuccessDataResult<>(addCategoryResponse);
    }

    @Override
    public DataResult<List<ListCategoryResponse>> getAll() {
        List<Category> categories = categoryDao.findAll();
        List<ListCategoryResponse> listCategoryResponses = categories.stream()
                .map(category -> modelMapperService.forResponse().map(category, ListCategoryResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(listCategoryResponses);
    }

    @Override
    public DataResult<Page<ListCategoryResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(categoryDao.getAll(pageable));
    }



    @Override
    public DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest updateCategoryRequest) {
        //checkIfCategoryWithIdExists(updateCategoryRequest.getId());

        Category category = categoryDao.findById(updateCategoryRequest.getId())
                .orElseThrow(() -> new NotFoundException("Category id is exists."));

        checkIfCategoryWithSameNameExists(updateCategoryRequest.getCategoryName());
        category.setCategoryName(updateCategoryRequest.getCategoryName());
        categoryDao.save(category);

        UpdateCategoryResponse updateCategoryResponse = modelMapperService.forResponse().map(category, UpdateCategoryResponse.class);
        return new SuccessDataResult<>(updateCategoryResponse);
    }

    @Override
    public Result categoryWithIdShouldExists(int categoryId) {
        boolean isCategoryExists = categoryDao.existsById(categoryId);
        if (isCategoryExists)
            return new SuccessResult();
        return new ErrorResult();
    }

    private void checkIfCategoryWithIdExists(int categoryId){
        if(!categoryWithIdShouldExists(categoryId).isSuccess())
            throw new NotFoundException("Category id is exists."); //TODO: Message service eklenicek.
    }

    private void checkIfCategoryWithSameNameExists(String categoryName){
        Category categoryToFind = categoryDao.findByCategoryName(categoryName);
        if (categoryToFind != null)
            throw new BusinessException("Category name is present."); //TODO: Message service eklenicek.
    }

    /*@Override
    public Category getById(int id) {
        Optional<Category> categoryOptional = categoryDao.findById(id);
        if (categoryOptional.isPresent()) {
            Category categoryToId = categoryOptional.get();
            return categoryToId;
        }
        return null;
    }*/
}
