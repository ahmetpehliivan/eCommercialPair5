package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.entities.concrete.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeDao extends JpaRepository<Attribute, Integer> {
}
