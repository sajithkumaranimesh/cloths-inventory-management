package com.pabaro.ims.mapper;

import com.pabaro.ims.entity.ProductEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductEntity> {
    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getBigDecimal("size"),
                rs.getBigDecimal("price"),
                rs.getInt("stock_quantity"),
                rs.getString("description"),
                rs.getBoolean("is_available"),
                rs.getString("created_at"),
                rs.getString("modified_at"),
                rs.getLong("supplier_id"),
                rs.getLong("category_id")
        );
    }
}
