package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.Result;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concrete.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    DataResult<AddCategoryResponse> add(AddCategoryRequest addCategoryRequest);
    DataResult<List<ListCategoryResponse>> getAll();
    DataResult<Page<ListCategoryResponse>>  getAllWithPagination(Pageable pageable);

    DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest updateCategoryRequest);
    //Category getById(int id);
    Result categoryWithIdShouldExists(int categoryId);

}
