package com.etiya.ecommercedemopair5.api.controllers;


import com.etiya.ecommercedemopair5.business.abstracts.CityService;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.IdCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.CityResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessResult;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    private CityService cityService;

    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public DataResult<CityResponse> add(@Valid @RequestBody AddCityRequest addCityRequest){
        return cityService.add(addCityRequest);
    }

    @GetMapping("")
    public DataResult<List<ListCityResponse>> getAll(){
        return cityService.getAll();
    }

    @GetMapping("getWithPagination")
    public DataResult<Page<ListCityResponse>> getAll(@RequestParam("page")int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return cityService.getAllWithPagination(pageable);
    }

    @PostMapping ("")
    public DataResult<CityResponse> getById(@RequestBody IdCityRequest idCityRequest){
        return cityService.getById(idCityRequest);
    }

    @PutMapping("")
    public DataResult<UpdateCityResponse> update(@Valid @RequestBody UpdateCityRequest updateCityRequest){
        return cityService.update(updateCityRequest);
    }

    @DeleteMapping("")
    public SuccessResult delete(@RequestBody IdCityRequest idCityRequest){
        return cityService.remove(idCityRequest);
    }

}
