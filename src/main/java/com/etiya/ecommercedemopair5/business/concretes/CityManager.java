package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.CityService;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.IdCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.CityResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercedemopair5.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair5.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair5.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessDataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessResult;
import com.etiya.ecommercedemopair5.entities.concrete.City;
import com.etiya.ecommercedemopair5.repositories.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityManager implements CityService {

    private final CityDao cityDao;
    private final ModelMapperService modelMapperService;

    @Autowired
    public CityManager(CityDao cityDao, ModelMapperService modelMapperService) {
        this.cityDao = cityDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<CityResponse> add(AddCityRequest addCityRequest) {
        checkIfCityWithSameNameExists(addCityRequest.getCityName());
        City city = modelMapperService.forRequest().map(addCityRequest, City.class);
        cityDao.save(city);
        CityResponse cityResponse = modelMapperService.forResponse().map(city, CityResponse.class);
        return new SuccessDataResult<>(cityResponse);
    }

    @Override
    public DataResult<List<ListCityResponse>> getAll() {
        List<City> cities = cityDao.findAll();
        List<ListCityResponse> listCityResponses = cities.stream()
                .map(city -> modelMapperService.forResponse().map(city, ListCityResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(listCityResponses);
    }

    @Override
    public DataResult<Page<ListCityResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(cityDao.getAll(pageable));
    }

    @Override
    public DataResult<UpdateCityResponse> update(UpdateCityRequest updateCityRequest) {
        City city = cityDao.findById(updateCityRequest.getId())
                .orElseThrow(() -> new NotFoundException("City id is exists."));
        checkIfCityWithSameNameExists(updateCityRequest.getCityName());
        city.setCityName(updateCityRequest.getCityName());
        cityDao.save(city);

        UpdateCityResponse updateCityResponse = modelMapperService.forResponse().map(city, UpdateCityResponse.class);
        return new SuccessDataResult<>(updateCityResponse);
    }

    @Override
    public SuccessResult remove(IdCityRequest idCityRequest) {
        checkIfCityWithIdExists(idCityRequest.getId());
        cityDao.deleteById(idCityRequest.getId());
        return new SuccessResult("Data deleted successfuly.");
    }

    @Override
    public DataResult<CityResponse> getById(IdCityRequest idCityRequest) {
        City city = cityDao.findById(idCityRequest.getId())
                .orElseThrow(() -> new NotFoundException("City id is exists."));
        CityResponse cityResponse = modelMapperService.forResponse().map(city, CityResponse.class);
        return new SuccessDataResult<>(cityResponse);
    }

    private void checkIfCityWithIdExists(int cityId){
        if(!cityDao.existsById(cityId))
            throw new NotFoundException("City id is exists."); //TODO: Message service eklenicek.
    }

    private void checkIfCityWithSameNameExists(String cityName){
        City cityToFind = cityDao.findByCityName(cityName);
        if (cityToFind != null)
            throw new BusinessException("City name is present."); //TODO: Message service eklenicek.
    }
}
