package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.entities.concrete.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
