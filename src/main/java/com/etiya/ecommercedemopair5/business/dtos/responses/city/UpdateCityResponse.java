package com.etiya.ecommercedemopair5.business.dtos.responses.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCityResponse {
    private int id;
    private String cityName;
}
