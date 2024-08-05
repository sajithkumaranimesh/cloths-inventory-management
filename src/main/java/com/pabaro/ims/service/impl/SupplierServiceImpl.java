package com.pabaro.ims.service.impl;

import com.pabaro.ims.dto.Supplier;
import com.pabaro.ims.entity.SupplierEntity;
import com.pabaro.ims.repository.SupplierJpaRepository;
import com.pabaro.ims.repository.SupplierRepository;
import com.pabaro.ims.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierJpaRepository jpaRepository;


    @Override
    public void persist(Supplier supplier) {
        jpaRepository.save(new ModelMapper().map(supplier, SupplierEntity.class));
    }
}
