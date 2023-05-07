package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.IdCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.CityResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {

    DataResult<CityResponse> add(AddCityRequest addCityRequest);
    DataResult<List<ListCityResponse>> getAll();

    DataResult<Page<ListCityResponse>>  getAllWithPagination(Pageable pageable);
    DataResult<UpdateCityResponse> update(UpdateCityRequest updateCityRequest);
    SuccessResult remove(IdCityRequest idCityRequest);
    DataResult<CityResponse> getById(IdCityRequest idCityRequest);

}
