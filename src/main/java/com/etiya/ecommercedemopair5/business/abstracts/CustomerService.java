package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.requests.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.ListCustomerResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.UpdateCustomerResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concrete.Customer;

import java.util.List;

public interface CustomerService {

    DataResult <AddCustomerResponse> add(AddCustomerRequest addCustomerRequest);
    DataResult<List<ListCustomerResponse>> getAll();
    DataResult<UpdateCustomerResponse> update(int id , UpdateCustomerRequest updateCustomerRequest);
   // Customer getById(int id);

}
