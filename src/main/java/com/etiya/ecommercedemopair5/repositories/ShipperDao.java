package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.entities.concrete.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperDao extends JpaRepository<Shipper, Integer> {
}
