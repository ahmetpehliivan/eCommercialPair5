package com.etiya.ecommercedemopair5.business.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCustomerRequest {
    private String firstName;
    private String lastName;

}
