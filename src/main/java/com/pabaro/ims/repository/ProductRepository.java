package com.pabaro.ims.repository;

import com.pabaro.ims.dto.Product;
import com.pabaro.ims.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    List<ProductEntity> findAll();
}
