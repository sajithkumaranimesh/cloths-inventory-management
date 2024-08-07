package com.pabaro.ims.repository.impl;

import com.pabaro.ims.entity.CategoryEntity;
import com.pabaro.ims.mapper.CategoryRowMapper;
import com.pabaro.ims.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CategoryEntity> findAll() {
        String sql = "SELECT id,name,description,created_at,modified_at FROM category";
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }
}
