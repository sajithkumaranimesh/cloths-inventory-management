package com.pabaro.ims.service;

import com.pabaro.ims.dto.Supplier;

import java.util.List;

public interface SupplierService {
    void persist(Supplier supplier);

    List<Supplier> retrieve();

    Supplier retrieveById(Long id);

    void update(Supplier supplier);

    void delete(Long id);
}
