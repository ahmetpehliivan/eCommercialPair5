package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair5.business.dtos.requests.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.ListCustomerResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.UpdateCustomerResponse;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/add")
    public DataResult<AddCustomerResponse> add(@Valid @RequestBody AddCustomerRequest addCustomerRequest){
        return customerService.add(addCustomerRequest);
    }

    @GetMapping("")
    public DataResult<List<ListCustomerResponse>> getAll(){
        return customerService.getAll();
    }

    @PutMapping("/{id}")
    public DataResult<UpdateCustomerResponse> update(@Valid @PathVariable int id,
                                                     @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.update(id,updateCustomerRequest);
    }

}
