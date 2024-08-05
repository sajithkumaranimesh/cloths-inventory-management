package com.pabaro.ims.repository;

import com.pabaro.ims.entity.SupplierEntity;

import java.util.List;

public interface SupplierRepository {
    List<SupplierEntity> retrieveAll();
}
