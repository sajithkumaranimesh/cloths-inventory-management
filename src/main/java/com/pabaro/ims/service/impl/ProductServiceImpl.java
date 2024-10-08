package com.pabaro.ims.service.impl;

import com.pabaro.ims.dto.Product;
import com.pabaro.ims.entity.ProductEntity;
import com.pabaro.ims.exception.ProductNotFoundException;
import com.pabaro.ims.repository.ProductJpaRepository;
import com.pabaro.ims.repository.ProductRepository;
import com.pabaro.ims.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository jpaRepository;
    private final ProductRepository repository;


    @Override
    public void persist(Product product) {
        jpaRepository.save(new ModelMapper().map(product, ProductEntity.class));
    }

    @Override
    public List<Product> retrieveAll() {

        List<Product> productList = new ArrayList<>();

        List<ProductEntity> productEntityList = repository.findAll();

        for (ProductEntity productEntity : productEntityList)
            productList.add(new ModelMapper().map(productEntity, Product.class));

        return productList;
    }

    @Override
    public Product retrieveById(Long id) {
        Optional<ProductEntity> productEntity = repository.findById(id);

        if (repository.findById(id).isEmpty())
            throw new ProductNotFoundException(String.format("%d No product found with this ID",id));

        return new ModelMapper().map(productEntity, Product.class);
    }

    @Override
    public void update(Product product) {
        ProductEntity productEntity = new ModelMapper().map(product, ProductEntity.class);

        if (repository.findById(product.getId()).isEmpty())
            throw new ProductNotFoundException(String.format("%s This Product Not Found",product));

        repository.update(productEntity);
    }

    @Override
    public void deleteById(Long id) {

        if (repository.findById(id).isEmpty())
            throw new ProductNotFoundException(String.format("%d No product found with this ID",id));

        repository.deleteById(id);
    }
}
