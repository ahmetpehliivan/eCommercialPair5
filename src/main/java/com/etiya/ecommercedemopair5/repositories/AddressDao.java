package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.entities.concrete.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
