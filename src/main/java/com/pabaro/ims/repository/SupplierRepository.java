package com.pabaro.ims.repository;

import com.pabaro.ims.entity.SupplierEntity;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository {
    List<SupplierEntity> findAll();

    Optional<SupplierEntity> findById(Long id);

    void update(SupplierEntity supplierEntity);

    void delete(Long id);
}
