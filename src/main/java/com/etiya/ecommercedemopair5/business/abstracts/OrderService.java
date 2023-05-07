package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessDataResult;

import java.util.List;

public interface OrderService {

    DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest);
    DataResult<List<ListOrderResponse> >getAll();
    SuccessDataResult<UpdateOrderResponse> update(int id ,UpdateOrderRequest updateOrderRequest);

}
