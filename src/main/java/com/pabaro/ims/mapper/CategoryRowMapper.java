package com.pabaro.ims.mapper;

import com.pabaro.ims.entity.CategoryEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoryRowMapper implements RowMapper<CategoryEntity> {

    @Override
    public CategoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CategoryEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("created_at"),
                rs.getString("modified_at"),
                null
        );
    }
}
