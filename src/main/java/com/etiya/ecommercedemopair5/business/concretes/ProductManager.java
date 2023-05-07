package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.entities.concrete.Product;
import com.etiya.ecommercedemopair5.repositories.ProductDao;
import com.etiya.ecommercedemopair5.business.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    @Override
    public void add(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public Product getById(int id) {
        Optional<Product> productOptional = productDao.findById(id);
        if (productOptional.isPresent()) {
            Product productToId = productOptional.get();
            return productToId;
        }
        return null;
    }
}
