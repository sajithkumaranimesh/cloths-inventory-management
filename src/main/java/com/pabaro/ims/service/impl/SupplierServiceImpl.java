package com.pabaro.ims.service.impl;

import com.pabaro.ims.dto.Supplier;
import com.pabaro.ims.entity.SupplierEntity;
import com.pabaro.ims.exception.SupplierNotFoundException;
import com.pabaro.ims.repository.SupplierJpaRepository;
import com.pabaro.ims.repository.SupplierRepository;
import com.pabaro.ims.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierJpaRepository jpaRepository;
    private final SupplierRepository repository;


    @Override
    public void persist(Supplier supplier) {

        jpaRepository.save(new ModelMapper().map(supplier, SupplierEntity.class));

    }




    @Override
    public List<Supplier> retrieve() {

        List<Supplier> supplierList = new ArrayList<>();

        List<SupplierEntity> supplierEntityList = repository.retrieveAll();

        for (SupplierEntity supplierEntity : supplierEntityList) {
            supplierList.add(new ModelMapper().map(supplierEntity, Supplier.class));
        }

        return supplierList;

    }




    @Override
    public Supplier retrieveById(Long id) {

        Optional<SupplierEntity> supplierEntity = repository.retrieveById(id);

        if (supplierEntity.isEmpty())
            throw new SupplierNotFoundException(String.format("%d No supplier found with this ID",id));

        return new ModelMapper().map(supplierEntity, Supplier.class);
    }




    @Override
    public void update(Supplier supplier) {

        SupplierEntity supplierEntity = new ModelMapper().map(supplier, SupplierEntity.class);

        if (repository.retrieveById(supplier.getId()).isEmpty())
            throw new SupplierNotFoundException(String.format("%s This Supplier Not Found",supplier));

        repository.update(supplierEntity);

    }




    @Override
    public void delete(Long id) {

        if (repository.retrieveById(id).isEmpty())
            throw new SupplierNotFoundException(String.format("%d No supplier found with this ID", id));

        repository.delete(id);

    }
}
