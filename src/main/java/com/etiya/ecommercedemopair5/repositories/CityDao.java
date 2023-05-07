package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercedemopair5.entities.concrete.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityDao extends JpaRepository<City, Integer> {

    City findByCityName(String cityName);
    //City findById(int id);

    @Query(value = "Select new " +
            "com.etiya.ecommercedemopair5.business.dtos.responses.city.ListCityResponse(c.id, c.cityName) " +
            "From City c",
            nativeQuery = false)
    Page<ListCityResponse> getAll(Pageable pageable);
}
