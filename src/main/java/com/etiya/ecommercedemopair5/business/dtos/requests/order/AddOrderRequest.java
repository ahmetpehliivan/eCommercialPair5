package com.etiya.ecommercedemopair5.business.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {

    private String shipName;
    private String shipAddress;
    private int employeeId;
    private int paymentId;

}
