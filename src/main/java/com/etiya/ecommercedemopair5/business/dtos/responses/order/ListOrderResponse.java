package com.etiya.ecommercedemopair5.business.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOrderResponse {

    private int id;
    private String shipName;
    private String shipAddress;
    private int employeeId;
    private int paymentId;
}
