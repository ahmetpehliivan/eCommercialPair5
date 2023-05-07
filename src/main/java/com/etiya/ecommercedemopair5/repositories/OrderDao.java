package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.entities.concrete.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
