package com.pabaro.ims.mapper;

import com.pabaro.ims.entity.SupplierEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierRowMapper implements RowMapper<SupplierEntity> {
    @Override
    public SupplierEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SupplierEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("company"),
                rs.getString("created_at"),
                rs.getString("modified_at")
        );
    }
}