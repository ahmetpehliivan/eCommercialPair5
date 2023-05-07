package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.business.abstracts.OrderService;
import com.etiya.ecommercedemopair5.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/add")
    public DataResult<AddOrderResponse> add(@Valid @RequestBody AddOrderRequest addOrderRequest){
        return orderService.add(addOrderRequest);
    }

    @GetMapping("")
    public DataResult<List<ListOrderResponse>> getAll(){
        return orderService.getAll();
    }

    @PutMapping("/{id}")
    public DataResult<UpdateOrderResponse> update(@Valid @PathVariable int id,
                                                  @RequestBody UpdateOrderRequest updateOrderRequest){
        return orderService.update(id,updateOrderRequest);
    }

}
