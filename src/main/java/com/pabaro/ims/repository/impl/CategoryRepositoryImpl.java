package com.pabaro.ims.repository.impl;

import com.pabaro.ims.entity.CategoryEntity;
import com.pabaro.ims.mapper.CategoryRowMapper;
import com.pabaro.ims.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CategoryEntity> findAll() {
        String sql = "SELECT id,name,description,created_at,modified_at FROM category";
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        String sql = "SELECT id,name,description,created_at,modified_at FROM category WHERE id = ?";
        return jdbcTemplate.query(sql, new CategoryRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public void update(CategoryEntity categoryEntity) {
        String sql = "UPDATE category SET name = ?,description = ?,created_at = ?,modified_at =?  WHERE id = ?";
        jdbcTemplate.update(sql,
                categoryEntity.getName(),
                categoryEntity.getDescription(),
                categoryEntity.getCreatedAt(),
                categoryEntity.getModifiedAt(),
                categoryEntity.getId()
        );
    }
}
