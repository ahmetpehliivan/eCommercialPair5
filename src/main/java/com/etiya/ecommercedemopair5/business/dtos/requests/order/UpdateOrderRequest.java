package com.etiya.ecommercedemopair5.business.dtos.requests.order;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {


    @NotNull(message = "adres alanı boş bırakılamaz.")
    private String shipAddress;
}
