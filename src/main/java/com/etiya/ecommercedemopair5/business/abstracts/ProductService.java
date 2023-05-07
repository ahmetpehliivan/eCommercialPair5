package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.entities.concrete.Product;

import java.util.List;

public interface ProductService {

    void add(Product product);
    List<Product> getAll();
    Product getById(int id);
}
