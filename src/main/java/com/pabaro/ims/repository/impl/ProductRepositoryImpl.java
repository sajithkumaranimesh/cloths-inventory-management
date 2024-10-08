package com.pabaro.ims.repository.impl;

import com.pabaro.ims.entity.ProductEntity;
import com.pabaro.ims.mapper.ProductRowMapper;
import com.pabaro.ims.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductEntity> findAll() {
        String sql = "SELECT id,name,size,price,stock_quantity,description," +
                "is_available,created_at,modified_at,supplier_id,category_id FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        String sql = "SELECT id,name,size,price,stock_quantity,description," +
                "is_available,created_at,modified_at,supplier_id,category_id FROM product WHERE id = ?";
        return jdbcTemplate.query(sql, new ProductRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public void update(ProductEntity productEntity) {
        String sql = "UPDATE product SET name = ?,size=?, price = ?, stock_quantity = ?, description = ?, is_available = ?, created_at = ?, modified_at = ?, supplier_id = ?, category_id = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                productEntity.getName(),
                productEntity.getSize(),
                productEntity.getPrice(),
                productEntity.getStockQuantity(),
                productEntity.getDescription(),
                productEntity.getIsAvailable(),
                productEntity.getCreatedAt(),
                productEntity.getModifiedAt(),
                productEntity.getSupplier_id(),
                productEntity.getCategory_id(),
                productEntity.getId()
        );
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
