package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.entities.concrete.Rebate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RebateDao extends JpaRepository<Rebate, Integer> {
}
