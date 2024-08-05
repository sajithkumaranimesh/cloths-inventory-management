package com.pabaro.ims.repository.impl;

import com.pabaro.ims.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
@RequiredArgsConstructor
public class SupplierRepositoryImpl implements SupplierRepository {

    private final JdbcTemplate jdbcTemplate;

}
