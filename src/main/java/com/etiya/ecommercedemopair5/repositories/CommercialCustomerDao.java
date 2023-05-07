package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.entities.concrete.CommercialCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommercialCustomerDao extends JpaRepository<CommercialCustomer, Integer> {
}
