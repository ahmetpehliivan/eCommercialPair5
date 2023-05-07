package com.etiya.ecommercedemopair5.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerResponse {

    private int id;
    private String firstName;
    private String lastName;
}
