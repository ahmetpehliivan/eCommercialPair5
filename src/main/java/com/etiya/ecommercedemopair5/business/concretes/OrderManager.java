package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.OrderService;
import com.etiya.ecommercedemopair5.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair5.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concrete.Order;
import com.etiya.ecommercedemopair5.repositories.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderManager implements OrderService {

    private final OrderDao orderDao;
    private final ModelMapperService modelMapperService;

    @Autowired
    public OrderManager(OrderDao orderDao, ModelMapperService modelMapperService) {
        this.orderDao = orderDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest) {
        Order order = modelMapperService.forRequest().map(addOrderRequest, Order.class);
        orderDao.save(order);
        AddOrderResponse addOrderResponse = modelMapperService.forResponse().map(order, AddOrderResponse.class);
        return new SuccessDataResult<AddOrderResponse>(addOrderResponse, "Sipariş eklendi");
    }

    @Override
    public DataResult< List<ListOrderResponse>> getAll() {
        List<Order> orders = orderDao.findAll();
        List<ListOrderResponse> listOrderResponses = orders.stream()
                .map(order->modelMapperService.forResponse().map(order, ListOrderResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListOrderResponse>>(listOrderResponses);

    }

    @Override
    public SuccessDataResult<UpdateOrderResponse> update(int id,UpdateOrderRequest updateOrderRequest) {
        Optional<Order> orderOptional = orderDao.findById(id);
        //Order order = orderDao.findById(id);
        Order order = modelMapperService.forRequest().map(updateOrderRequest, Order.class);
        order.setShipAddress(updateOrderRequest.getShipAddress());
        orderDao.save(order);
        UpdateOrderResponse updateOrderResponse = modelMapperService.forResponse().map(order, UpdateOrderResponse.class);
        return new SuccessDataResult<UpdateOrderResponse>(updateOrderResponse, "Sipariş adresi güncellendi.");
    }
}
