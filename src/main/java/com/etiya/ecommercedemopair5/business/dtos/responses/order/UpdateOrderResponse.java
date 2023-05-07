package com.etiya.ecommercedemopair5.business.dtos.responses.order;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderResponse {
    private int id;
    @Size(max = 300, message = "Adres alanı 300 karakterden uzun olamaz")
    private String shipAddress;
}
