package com.pabaro.ims.service;

import com.pabaro.ims.dto.Product;
import com.pabaro.ims.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    void persist(Product product);

    List<Product> retrieveAll();

    Product retrieveById(Long id);

    void update(Product product);

    void deleteById(Long id);
}
