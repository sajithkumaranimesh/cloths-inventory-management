package com.pabaro.ims.repository;

import com.pabaro.ims.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(Long id);

    void update(ProductEntity productEntity);
}
