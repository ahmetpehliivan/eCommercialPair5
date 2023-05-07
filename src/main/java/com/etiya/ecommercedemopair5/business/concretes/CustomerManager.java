package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.dtos.requests.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.ecommercedemopair5.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.ListCustomerResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.customer.UpdateCustomerResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair5.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair5.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.utils.result.DataResult;
import com.etiya.ecommercedemopair5.core.utils.result.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concrete.Customer;
import com.etiya.ecommercedemopair5.entities.concrete.Order;
import com.etiya.ecommercedemopair5.repositories.CustomerDao;
import com.etiya.ecommercedemopair5.business.abstracts.CustomerService;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private final CustomerDao customerDao;
    private final ModelMapperService modelMapperService;

    @Autowired
    public CustomerManager(CustomerDao customerDao, ModelMapperService modelMapperService) {
        this.customerDao = customerDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<AddCustomerResponse> add(AddCustomerRequest addCustomerRequest) {

        //Customer customer = new Customer();
        //customer.setFirstName(addCustomerRequest.getFirstName());
        //customer.setLastName(addCustomerRequest.getLastName());
        //customer.setEmail(addCustomerRequest.getEmail());
        //customer.setPhoneNumber(addCustomerRequest.getPhoneNumber());

        Customer customer = modelMapperService.forRequest().map(addCustomerRequest, Customer.class);
        customerDao.save(customer);
        AddCustomerResponse response = modelMapperService.forResponse().map(customer, AddCustomerResponse.class);

        //AddCustomerResponse response = new AddCustomerResponse(
          //      customer.getId(),
            //    customer.getFirstName(),
              //  customer.getLastName());

        return new DataResult<AddCustomerResponse>(response, true, "Customer added.");

    }

    @Override
    public DataResult< List<ListCustomerResponse>> getAll() {
        List<Customer> customers = customerDao.findAll();
        List<ListCustomerResponse> listCustomerResponses = customers.stream()
                .map(customer->modelMapperService.forResponse().map(customer, ListCustomerResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListCustomerResponse>>(listCustomerResponses);

    }

    @Override
    public SuccessDataResult<UpdateCustomerResponse> update(int id, UpdateCustomerRequest updateCustomerRequest) {
        Optional<Customer> customerOptional = customerDao.findById(id);
        //Order order = orderDao.findById(id);
        Customer customer = modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());
        customerDao.save(customer);
        UpdateCustomerResponse updateCustomerResponse = modelMapperService.forResponse().map(customer, UpdateCustomerResponse.class);
        return new SuccessDataResult<UpdateCustomerResponse>(updateCustomerResponse, "ad-soyad güncellendi.");
    }


    //@Override
   // public Customer getById(int id) {
     //   Optional<Customer> customerOptional = customerDao.findById(id);
       // if (customerOptional.isPresent()) {
         //   Customer customerToId = customerOptional.get();
           // return customerToId;
        //}
        //return null;
    //}
}
