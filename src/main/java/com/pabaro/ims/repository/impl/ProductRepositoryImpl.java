package com.pabaro.ims.repository.impl;

import com.pabaro.ims.entity.ProductEntity;
import com.pabaro.ims.mapper.ProductRowMapper;
import com.pabaro.ims.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductEntity> findAll() {
        String sql = "SELECT id,name,size,price,stock_quantity," +
                "description,is_available,created_at,modified_at,supplier_id,category_id FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }
}
