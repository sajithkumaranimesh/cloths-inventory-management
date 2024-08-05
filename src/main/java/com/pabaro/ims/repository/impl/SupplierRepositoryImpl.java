package com.pabaro.ims.repository.impl;


import com.pabaro.ims.entity.SupplierEntity;
import com.pabaro.ims.mapper.EmployeeRowMapper;
import com.pabaro.ims.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SupplierRepositoryImpl implements SupplierRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<SupplierEntity> retrieveAll() {
        String sql = "SELECT id,name,email,company,created_at,modified_at FROM supplier";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Optional<SupplierEntity> retrieveById(Long id) {
        String sql = "SELECT id,name,email,company,created_at,modified_at FROM supplier WHERE id = ?";
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public void update(SupplierEntity supplierEntity) {
        String sql = "UPDATE supplier SET name = ?,email = ?,company = ?,created_at = ?,modified_at = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                supplierEntity.getName(),
                supplierEntity.getEmail(),
                supplierEntity.getCompany(),
                supplierEntity.getCreatedAt(),
                supplierEntity.getModifiedAt(),
                supplierEntity.getId()
        );
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM supplier WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}