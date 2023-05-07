package com.etiya.ecommercedemopair5.business.dtos.requests.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {


    private String productName;
    private double unitPrice;

}
